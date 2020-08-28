package cachesoftreference;
import java.io.*;
import java.nio.file.Files;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.08.2020
 * email roman9628@gmail.com
 * The class create instance File from string.
 */
public class ReadFromDiskWay implements WayGetValue<String,byte[]> {
    /**
     * The method get value.
     * @return V value.
     */
    @Override
    public byte[] getValue(String key) {
        byte[] result = null;
        File fileWithPath = new File("2.Level-Junior/GarbageCollection"
                + "/src/main/resources/" + key);
        try {
            result = Files.readAllBytes(fileWithPath.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result == null) {
            throw new IllegalStateException(
                    String.format("Can't read from file: %s", fileWithPath));
        }
        return result;
    }
}