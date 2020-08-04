package fileoutputstream;
import java.util.Arrays;
/**
 * The class create Multiplication table specified size.
 */
public class Matrix {
    /**
     * The method fill array multiplication table.
     * @param size size table.
     * @return 2 Dimension array.
     */
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    /**
     * The method convert array to String.
     * @param table Array with table.
     * @return Converted array to string.
     */
    public static String printMatrix(int[][] table) {
        return Arrays.deepToString(table);
    }
}