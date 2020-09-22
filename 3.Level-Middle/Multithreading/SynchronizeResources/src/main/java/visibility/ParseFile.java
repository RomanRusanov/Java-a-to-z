package visibility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.09.2020
 * email roman9628@gmail.com
 * The class parse file.
 */
public class ParseFile {
    /**
     * The field contain file instance.
     * File for load and save content.
     */
    private volatile File file;

    /**
     * The method Setter for field.
     * @param f File.
     */
    public synchronized void setFile(File f) {
        file = f;
    }

    /**
     * The Getter for filed.
     * @return File.
     */
    public synchronized File getFile() {
        return file;
    }

    /**
     * The method parse strings from String array.
     * @return String.
     */
    public synchronized String getContent() {
        StringBuffer buffer = new StringBuffer();
        for (String str: this.loadContentFromFile()) {
            buffer.append(str + System.getProperty("line.separator"));
        }
        return buffer.toString();
    }

    /**
     * The method load strings from file and store each string in array.
     * @return String array.
     */
    public synchronized String[] loadContentFromFile() {
        String[] result = new String[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            result = reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * The method parse string and store all symbols
     * except chars > 128(0x80) in unicode table.
     * @return String.
     */
    public synchronized String getContentWithoutUnicode() {
        StringBuffer buffer = new StringBuffer();
        for (String str: this.loadContentFromFile()) {
            str.chars().filter(c -> c < 0x80)
                    .forEach(c -> buffer.append(Character.valueOf((char) c)));
            buffer.append(System.getProperty("line.separator"));
        }
        return buffer.toString();
    }

    /**
     * The method write String in file.
     * @param content String to write.
     */
    public synchronized void saveContent(String content) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(file))) {
            w.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}