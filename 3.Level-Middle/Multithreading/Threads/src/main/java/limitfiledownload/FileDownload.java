package limitfiledownload;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.09.2020
 * email roman9628@gmail.com
 * The class download file with limits by speed.
 * program arguments (-url= file for downloading -limit= speed downloading in bytes sec.)
 * -url=https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml
 * -limit=200
 */
public class FileDownload {
    /**
     * The main method.
     * @param args Passed arguments.
     */
    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        int bufferSize = 1024;
        int delay = 0;
        int limit = Integer.parseInt(argsName.get("limit"));
        String file = argsName.get("url");
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(
                     "3.Level-Middle/Multithreading/Threads/src/main/resources/pom_tmp.xml"
             )) {
            byte[] dataBuffer = new byte[bufferSize];
            int bytesRead;
            int allBytesRead = 0;
            while ((bytesRead = in.read(dataBuffer, 0, bufferSize)) != -1) {
                allBytesRead += bytesRead;
                if (bytesRead > limit) {
                    delay = bytesRead - limit;
                }
                System.out.println("all = Read = Delay(m.sec)");
                System.out.println(allBytesRead + " = " + bytesRead + " = " + delay);
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Thread.sleep(delay);
                delay = 0;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}