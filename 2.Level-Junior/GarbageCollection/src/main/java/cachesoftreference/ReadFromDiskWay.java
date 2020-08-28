package cachesoftreference;
import java.io.File;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.08.2020
 * email roman9628@gmail.com
 * The class create instance File from string.
 */
public class ReadFromDiskWay implements WayGetValue<String, File> {
    /**
     * The method get value.
     * @return V value.
     */
    @Override
    public File getValue(String key) {
        return new File(key);
    }
}