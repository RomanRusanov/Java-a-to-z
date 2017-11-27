package ru.rrusanov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ElephantTest {
    @Test
    public void thenUserChooseCorrectCellForDestinationWhenReturnCellArray() throws ImpossibleCreateCellException{
        Elephant elephant = new Elephant(new Cell(1,1));
        Cell[] result = elephant.way(new Cell(3,3));
        Cell[] expect = new Cell[] {new Cell(2,2), new Cell(3,3)};
        Assert.assertThat(result, is(expect));
    }
}