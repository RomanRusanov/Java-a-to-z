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
     * The instance of beast.
     */
    private final Beast beast = new Beast(new Cell(9, 9));
    /**
     * Default constructor.
     */
    public Board() {
        this.initBoard();
        this.placeWalls();
    }
    /**
     * The method check can move from source cell to dest cell. Check ReentrantLock array.
     * @param source cell
     * @param dist cell
     * @return true if dist cell empty then lock it and unlock source, otherwise return false and source stay locked.
     */
    public boolean move(Cell source, Cell dist) {
        boolean result = false;
        try {
            if (this.board[dist.getX()][dist.getY()].tryLock(500, TimeUnit.MILLISECONDS)) {
                this.board[source.getX()][source.getY()].unlock();
                result = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * The method move hero.
     * @param player to move.
     */
    public void playerGo(Player player) {
        Cell positionHero = new Cell(player.getPosition());
        Cell positionTryCell = player.move();
        boolean turnSuccess = false;
        while (!turnSuccess) {
            if (this.move(positionHero, positionTryCell)) {
                player.setPosition(positionTryCell);
                turnSuccess = true;
                //wait one second.
                try {
                    this.board[player.getPosition().getX()][player.getPosition().getY()].newCondition().await(100, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                player.applyChangeDirection();
                positionTryCell = player.move();
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
     * The method place walls on board. A player can't take this position.
     */
    public void placeWalls() {
        this.board[1][0].lock();
        this.board[2][0].lock();
        this.board[3][0].lock();
        this.board[4][0].lock();
        this.board[6][1].lock();
        this.board[8][1].lock();
        this.board[0][2].lock();
        this.board[1][2].lock();
        this.board[2][2].lock();
        this.board[4][2].lock();
        this.board[6][2].lock();
        this.board[8][2].lock();
        this.board[4][3].lock();
        this.board[5][3].lock();
        this.board[6][3].lock();
        this.board[8][3].lock();
        this.board[1][4].lock();
        this.board[2][4].lock();
        this.board[4][4].lock();
        this.board[6][4].lock();
        this.board[2][5].lock();
        this.board[8][5].lock();
        this.board[1][6].lock();
        this.board[2][6].lock();
        this.board[4][6].lock();
        this.board[5][6].lock();
        this.board[6][6].lock();
        this.board[8][6].lock();
        this.board[1][8].lock();
        this.board[2][8].lock();
        this.board[3][8].lock();
        this.board[5][8].lock();
        this.board[6][8].lock();
        this.board[7][8].lock();
        this.board[9][8].lock();
    }
    /**
     * Thread with players(player or beast) on board.
     */
    @Override
    public void run() {
        // place players on board
        this.board[this.hero.getPosition().getX()][this.hero.getPosition().getY()].lock();
        this.board[this.beast.getPosition().getX()][this.beast.getPosition().getY()].lock();
        while (true) {
            //Turn player.
            this.playerGo(this.hero);
            this.playerGo(this.beast);
            //Show current position player, and direction.
            System.out.println("Hero:" + this.hero.getPosition() + "Direction:" + this.hero.getDirection());
            System.out.println("Beast:" + this.beast.getPosition() + "Direction:" + this.beast.getDirection());
            //Check Hero lose?
            if (this.hero.getPosition().equals(this.beast.getPosition())) {
                System.out.println("The Hero lose!");
                break;
            }
        }
    }
}
