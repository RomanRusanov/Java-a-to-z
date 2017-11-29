package ru.rrusanov;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

/** Class contains tests for Board class.
 * @author Roman Rusanov
 * @since 29.11.2017
 * @version 0.1
 */
public class BoardTest {
    @Test
    public void move() throws Exception {
    }

    @Test
    public void thenAddNewFigureWhenArrayFiguresGetIt() throws ImpossibleCreateCellException {
        Board board = new Board();
        Figure expect = new Elephant(new Cell(3,1));
        board.addNewFigure(expect);
        Figure result = board.lastAddedFigure();
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void getOccupiedCells() throws Exception {
    }

}