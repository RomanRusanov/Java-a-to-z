package ru.rrusanov;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
/** Class contains tests for Elephant class.
 * @author Roman Rusanov
 * @since 29.11.2017
 * @version 0.1
 */
public class ElephantTest {
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
     * Value of cell for test.
     */
    private static final int SIX = 6;
    /**
     * Value of cell for test.
     */
    private static final int SEVEN = 7;
    /**
     * Check way of figure.
     * @throws ImpossibleCreateCellException Possibly wrong value x,y for create cell.
     */
    @Test
    public void thenUserChooseCorrectCellForDestinationWhenReturnCellArray() throws ImpossibleCreateCellException {
        Elephant elephant = new Elephant(new Cell(FOUR, FOUR));
        Cell[] result = elephant.way(new Cell(1, SEVEN));
        Cell[] expect = new Cell[] {new Cell(THREE, FIVE), new Cell(2, SIX), new Cell(1, SEVEN)};
        Assert.assertThat(result, is(expect));
    }
}