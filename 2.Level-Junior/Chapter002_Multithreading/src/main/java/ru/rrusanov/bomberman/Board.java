package ru.rrusanov.bomberman;
import java.util.concurrent.locks.ReentrantLock;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Board {

    private final ReentrantLock[][] board = new ReentrantLock[10][10];

    private final Hero hero = new Hero(new Cell(0, 0));

    public Board() {
        this.board[this.hero.getPosition().getX()][this.hero.getPosition().getY()].lock();
    }
    public boolean move(Cell source, Cell dist) {
        boolean result = false;
        try {
            if(this.board[dist.getX()][dist.getY()].tryLock(500, MILLISECONDS)) {
                this.board[source.getX()][source.getY()].unlock();
                this.hero.setPosition(new Cell(source.getX(), source.getY()));
                result = true;
            } else {
                this.hero.applyChangeDirection();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void heroTurn(Hero hero) {
        Cell positionHero = hero.getPosition();
        while (!this.move(positionHero, hero.move())) {
            hero.applyChangeDirection();
        }
    }
}
