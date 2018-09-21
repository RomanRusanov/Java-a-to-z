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
    /**
     * Value of cell for test.
     */
    private static final int THREE = 3;
    /**
     * Value of cell for test.
     */
    private static final int FOUR = 4;
    /**
     * Value of cell for test.
     */
    private static final int FIVE = 5;
    /**
     * @throws ImpossibleMoveException If destination cell busy or on way exist other figure generate exception.
     * @throws OccupiedWayException If way of movement of figure cross another figure.
     * @throws FigureNotFoundException If source cell not have figure exist.
     * @throws ImpossibleCreateCellException Possibly wrong value x,y for create cell.
     */
    /**
     * Checks method getFigureFromCell.
     * @throws ImpossibleCreateCellException Possibly wrong value x,y for create cell.
     */
    @Test
    public void thenGetFigureFromCellWhenReturnFigure() throws ImpossibleCreateCellException {
        Board board = new Board();
        Cell cell = new Cell(THREE, THREE);
        Figure expect = new Elephant(cell);
        board.addNewFigure(expect);
        Figure result = board.getFigureFromCell(cell);
        Assert.assertThat(result, is(expect));
    }
    /**
     * Check method move.
     * @throws ImpossibleMoveException If destination cell busy or on way exist other figure generate exception.
     * @throws OccupiedWayException If way of movement of figure cross another figure.
     * @throws FigureNotFoundException If source cell not have figure exist.
     * @throws ImpossibleCreateCellException Possibly wrong value x,y for create cell.
     */
    @Test
    public void thenMoveFigureWhenReturnTrueOrThrowException() throws ImpossibleCreateCellException, ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {
        Board board = new Board();
        Cell cell = new Cell(FOUR, FOUR);
        Figure elephant = new Elephant(cell);
        board.addNewFigure(elephant);
        Assert.assertTrue(board.move(cell, new Cell(THREE, FIVE)));
    }
    /**
     * Check method addNewFigure.
     * @throws ImpossibleCreateCellException Possibly wrong value x,y for create cell.
     */
    @Test
    public void thenAddNewFigureWhenArrayFiguresGetIt() throws ImpossibleCreateCellException {
        Board board = new Board();
        Figure expect = new Elephant(new Cell(THREE, 1));
        board.addNewFigure(expect);
        Figure result = board.lastAddedFigure();
        Assert.assertThat(result, is(expect));
    }
    /**
     * Check method getOccupiedCells.
     * @throws ImpossibleCreateCellException Possibly wrong value x,y for create cell.
     */
    @Test
    public void thenOnBoardExistFiguresWhenReturnThemCells() throws ImpossibleCreateCellException  {
        Board board = new Board();
        Cell cell = new Cell(1, 1);
        Figure figure = new Elephant(cell);
        board.addNewFigure(figure);
        Cell[] result = board.getOccupiedCells();
        Cell[] expect = new Cell[] {cell};
        Assert.assertThat(result, is(expect));
    }
}