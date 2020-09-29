package visibility;

import net.jcip.annotations.ThreadSafe;
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
@ThreadSafe
public class ParseFile {
    /**
     * The field contain file instance.
     * File for load and save content.
     */
    private File file;
    /**
     * The field contain false if method write doesn't pass for
     * current instance file. True when data stored to file.
     */
    private boolean isLoad = true;
    /**
     * The method Setter for field.
     * @param f File.
     * @return If field state change return true, otherwise,
     * if method getContent not passed we can't change file.
     */
    public synchronized boolean setFile(File f) {
        boolean result = false;
        if (isLoad) {
            file = f;
            isLoad = false;
            result = true;
        }
        return result;
    }

    /**
     * The Getter for filed.
     * @return File.
     */
    public synchronized File getFile() {
        return new File(String.valueOf(this.file));
    }

    /**
     * The method parse strings from String array.
     * @return String.
     */
    public synchronized String getContent() {
        StringBuilder buffer = new StringBuilder();
        for (String str: this.loadContentFromFile()) {
            buffer.append(str + System.getProperty("line.separator"));
        }
        this.isLoad = true;
        return buffer.toString();
    }

    /**
     * The method load strings from file and store each string in array.
     * @return String array.
     */
    public String[] loadContentFromFile() {
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
        StringBuilder buffer = new StringBuilder();
        for (String str: this.loadContentFromFile()) {
            str.chars().filter(c -> c < 0x80)
                    .forEach(c -> buffer.append(Character.valueOf((char) c)));
            buffer.append(System.getProperty("line.separator"));
        }
        this.isLoad = true;
        return buffer.toString();
    }

    /**
     * The method write String in file.
     * @param content String to write.
     */
    public void saveContent(String content) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(file))) {
            w.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}