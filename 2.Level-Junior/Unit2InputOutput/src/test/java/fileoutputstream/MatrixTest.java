package fileoutputstream;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
/**
 * The class check behavior Matrix.java.
 */
public class MatrixTest {
    /**
     * Test check when create table size 4 when array size [4][4] elements.
     */
    @Test
    public void whenCreateTableWithSize4ThenTableSize4x4Elements() {
        int[][] table = Matrix.multiple(4);
        int[][] expect = {
                {1, 2, 3, 4},
                {2, 4, 6, 8},
                {3, 6, 9, 12},
                {4, 8, 12, 16}};
                assertArrayEquals(expect, table);

    }
}