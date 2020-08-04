package fileoutputstream;
import java.io.FileOutputStream;
/**
 * The class write string to file on drive.
 */
public class Output {
    /**
     * The method write string to file.
     * @param stringOut String to write.
     * @param fileName Filename.
     */
    public void writeToFile(String stringOut, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            out.write(stringOut.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}