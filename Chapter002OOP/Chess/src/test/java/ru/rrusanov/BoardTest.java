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
    public void getFigureFromCell() throws ImpossibleCreateCellException {
        Board board = new Board();
        Cell cell = new Cell(3,3);
        Figure expect = new Elephant(cell);
        board.addNewFigure(expect);
        Figure result = board.getFigureFromCell(cell);
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void move() throws ImpossibleCreateCellException, ImpossibleMoveException, FigureNotFoundException, OccupiedWayException{
        Board board = new Board();
        Cell cell = new Cell(4,4);
        Figure elephant = new Elephant(cell);
        board.addNewFigure(elephant);
        Assert.assertTrue(board.move(cell, new Cell(3,5)));
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
        Board board = new Board();
        Cell cell = new Cell(1,1);
        Figure figure = new Elephant(cell);
        board.addNewFigure(figure);
        Cell[] result = board.getOccupiedCells();
        Cell[] expect = new Cell[] {cell};
        Assert.assertThat(result, is(expect));
    }

}