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
        int startBufferSize = 1024;
        int limit = Integer.parseInt(argsName.get("limit"));
        String file = argsName.get("url");
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(
                     "3.Level-Middle/Multithreading/Threads/src/main/resources/pom_tmp.xml"
             )) {
            int bufferSize = startBufferSize;
            byte[] dataBuffer = new byte[bufferSize];
            int bytesRead;
            int allBytesRead = 0;
            while ((bytesRead = in.read(dataBuffer, allBytesRead, bufferSize)) != -1) {
                long beforeRead = System.nanoTime();
                allBytesRead += bytesRead;
                if (bytesRead < bufferSize) {
                    bufferSize -= allBytesRead;
                    continue;
                }
                fileOutputStream.write(dataBuffer, 0, allBytesRead);
                long afterRead = -(beforeRead - System.nanoTime());
                bufferSize = startBufferSize;
                allBytesRead = 0;
                Thread.sleep(delay(afterRead, limit));
            }
            fileOutputStream.write(dataBuffer, 0, allBytesRead);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method calculate delay in milliseconds depending of speed downloading.
     * @param afterRead How many nanoseconds need to process 1 data buffer.
     * @param limit Limit of max speed download in KB/sec passed of user.
     * @return In MillisSeconds delay of thread sleep.
     */
    public static long delay(long afterRead, int limit) {
        double delay;
        double process1DataBufferInSeconds = (double) afterRead / 1_000_000_000.0;
        double howManySecondsNeedToLoadWithLimit = process1DataBufferInSeconds * limit;
        double countDelay = 1 - howManySecondsNeedToLoadWithLimit;
        delay =  countDelay < 0 ? 0 : countDelay;
        long delayInMillisSeconds = (long) (delay * 1_000);
        System.out.println("Delay in milliseconds:" + delayInMillisSeconds);
        return delayInMillisSeconds;
    }
}