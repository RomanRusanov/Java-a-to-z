package fileoutputstream;
import org.junit.Test;
import java.io.FileInputStream;
import static org.junit.Assert.assertEquals;
/**
 * The class check behavior Output.java.
 */
public class OutputTest {
    /**
     * Field contain file name to write out on disk.
     */
    private String filename = "result.txt";
    /**
     * Field contain instance ot test class.
     */
    private Output output = new Output();
    /**
     * The test check when write on disk string then was write same string.
     */
    @Test
    public void whenMatrixLoadToFileThenFileContainMatrix() {
        int[][] table = Matrix.multiple(5);
        String stringWithMatrix = Matrix.printMatrix(table);
        output.writeToFile(stringWithMatrix, filename);
        try (FileInputStream in = new FileInputStream(filename)) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            assertEquals(stringWithMatrix, text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}