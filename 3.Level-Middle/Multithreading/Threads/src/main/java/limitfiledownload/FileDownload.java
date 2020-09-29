package limitfiledownload;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

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
public class FileDownload implements Callable<Path> {
    /**
     * The field contain instance that work with args.
     */
    public final ArgsName argsName;
    /**
     * The field contain url to load.
     */
    private final String url;
    /**
     * The field contain value download limit.
     */
    private final int limit;
    /**
     * The field contain string path with file name to store downloaded file.
     */
    private final String file;

    /**
     * The default constructor.
     * @param args Passed args.
     */
    public FileDownload(String[] args) {
        this.argsName = ArgsName.of(args);
        this.url = argsName.get("url");
        this.limit = Integer.parseInt(argsName.get("limit"));
        this.file = "3.Level-Middle/"
                + "Multithreading/Threads/src/main/resources/pom_tmp.xml";
    }
    /**
     * The method calculate delay in milliseconds depending of speed downloading.
     * @param afterRead How many nanoseconds need to process 1 data buffer.
     * @param limit Limit of max speed download in KB/sec passed of user.
     * @return In MillisSeconds delay of thread sleep.
     */
    public long delay(long afterRead, int limit) {
        double delay;
        double process1DataBufferInSeconds = (double) afterRead / 1_000_000_000.0;
        double howManySecondsNeedToLoadWithLimit = process1DataBufferInSeconds * limit;
        double countDelay = 1 - howManySecondsNeedToLoadWithLimit;
        delay =  countDelay < 0 ? 0 : countDelay;
        long delayInMillisSeconds = (long) (delay * 1_000);
        System.out.println("Delay in milliseconds:" + delayInMillisSeconds);
        return delayInMillisSeconds;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     * Method take input url as stream symbols. startBufferSize - how many
     * data read and write in one step. bufferSize = startBufferSize - how many
     * data load in previously iteration, if iteration read not full buffer.
     * dataBuffer - contain bytes from in stream, and source to write to
     * fileOutputStream stream.
     * beforeRead - time before operation(read - write).
     * bytesRead - in one iteration in.read.
     * allBytesRead - in period one buffer.
     * fileOutputStream - stream to write all bytes from dataBuffer.
     * @return Path instance with downloaded file.
     * @throws Exception if unable to compute a result.
     */
    @Override
    public Path call() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(this.url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(
                     this.file
             )) {
            int startBufferSize = 1024;
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
                Thread.sleep(this.delay(afterRead, this.limit));
            }
            fileOutputStream.write(dataBuffer, 0, allBytesRead);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Paths.get(this.file);
    }
}