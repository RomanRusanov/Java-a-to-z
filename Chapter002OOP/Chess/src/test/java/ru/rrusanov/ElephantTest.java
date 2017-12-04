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
    @Test
    public void thenUserChooseCorrectCellForDestinationWhenReturnCellArray() throws ImpossibleCreateCellException{
        Elephant elephant = new Elephant(new Cell(4,4));
        Cell[] result = elephant.way(new Cell(1,7));
        Cell[] expect = new Cell[] {new Cell(3,5), new Cell(2,6), new Cell(1,7)};
        Assert.assertThat(result, is(expect));
    }
}