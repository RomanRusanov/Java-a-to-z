package ru.rrusanov.bomberman;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Board implements Runnable{

    private final ReentrantLock[][] board = new ReentrantLock[10][10];

    private final Hero hero = new Hero(new Cell(0, 0));

    public Board() {
        this.initBoard();
    }
    public synchronized boolean move(Cell source, Cell dist) {
        boolean result = false;
        if (!this.board[dist.getX()][dist.getY()].isLocked() &&
                this.board[dist.getX()][dist.getY()].tryLock()
        ) {
            this.board[source.getX()][source.getY()].unlock();
            result = true;
        }
        return result;
    }

    public synchronized void heroGo(Hero hero) {

        Cell positionHero = new Cell(hero.getPosition());
        Cell positionTryCell = this.hero.move();
        boolean turnSuccess = false;
        if (this.move(positionHero, positionTryCell)) {
            this.hero.setPosition(positionTryCell);
            try {
                this.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                while (!turnSuccess) {
                    if (!this.board[positionTryCell.getX()][positionTryCell.getY()].isLocked() &&
                            this.board[positionTryCell.getX()][positionTryCell.getY()].tryLock()
                    ) {
                        this.board[positionHero.getX()][positionHero.getY()].unlock();
                        this.hero.setPosition(positionTryCell);
                        turnSuccess = true;
                        this.wait(1000);
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

    public void initBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }

    @Override
    public void run() {
        this.board[2][0].tryLock();
        this.board[this.hero.getPosition().getX()][this.hero.getPosition().getY()].lock();
        while(true) {

            this.heroGo(this.hero);
            System.out.println(this.hero.getPosition());
        }
    }
}
