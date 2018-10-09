package ru.rrusanov.bomberman;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 7.10.2018
 *
 * The class describe board implementation and players on it.
 */
public class Board implements Runnable {
    /**
     * The instance contain lock array. If players on cell then element locked.
     */
    private final ReentrantLock[][] board = new ReentrantLock[10][10];
    /**
     * The instance of hero.
     */
    private final Hero hero = new Hero(new Cell(0, 0));
    /**
     * Default constructor.
     */
    public Board() {
        this.initBoard();
    }
    /**
     * The method check can move from source cell to dest cell. Check ReentrantLock array.
     * @param source cell
     * @param dist cell
     * @return true if dist cell empty then lock it and unlock source, otherwise return false and source stay locked.
     */
    public boolean move(Cell source, Cell dist) {
        boolean result = false;
        if (!this.board[dist.getX()][dist.getY()].isLocked()
                && this.board[dist.getX()][dist.getY()].tryLock()
        ) {
            this.board[source.getX()][source.getY()].unlock();
            result = true;
        }
        return result;
    }
    /**
     * The method move hero.
     * @param hero to move.
     */
    public void heroGo(Hero hero) {
        Cell positionHero = new Cell(hero.getPosition());
        Cell positionTryCell = this.hero.move();
        boolean turnSuccess = false;
        if (this.move(positionHero, positionTryCell)) {
            this.hero.setPosition(positionTryCell);
            //wait one second.
            try {
                this.board[this.hero.getPosition().getX()][this.hero.getPosition().getY()].newCondition().await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                while (!turnSuccess) {
                    if (!this.board[positionTryCell.getX()][positionTryCell.getY()].isLocked()
                            && this.board[positionTryCell.getX()][positionTryCell.getY()].tryLock(500, TimeUnit.MILLISECONDS)
                    ) {
                        this.board[positionHero.getX()][positionHero.getY()].unlock();
                        this.hero.setPosition(positionTryCell);
                        turnSuccess = true;
                        //wait one second.
                        try {
                            this.board[this.hero.getPosition().getX()][this.hero.getPosition().getY()].newCondition().await(1000, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.hero.applyChangeDirection();
                        positionTryCell = this.hero.move();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * The method initiate board.
     */
    public void initBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }
    /**
     * Thread with players(hero or beast) on board.
     */
    @Override
    public void run() {
        // place hero on board
        this.board[this.hero.getPosition().getX()][this.hero.getPosition().getY()].lock();
        while (true) {
            //Turn hero.
            this.heroGo(this.hero);
            //Show current position hero.
            System.out.println(this.hero.getPosition());
            //Show current direction hero.
            System.out.println(this.hero.getDirection());
        }
    }
}
