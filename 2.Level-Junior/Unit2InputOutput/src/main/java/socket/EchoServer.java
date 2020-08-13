package socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.08.2020
 * email roman9628@gmail.com
 * The class send and receive simple http packets.
 * If Server receive string contain "msg=Bye" then server shutdown.
 */
public class EchoServer {
    /**
     * The field contain pattern for regular expression.
     */
    static Pattern pattern = Pattern.compile("^.*msg=Bye.*$");

    /**
     * The main method.
     * @param args String args.
     * @throws IOException may throw I/O exception.
     */
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean work = true;
            while (work) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (checkMsg(str)) {
                            work = false;
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }

    /**
     * The method check match string to regex.
     * @param msg String to check.
     * @return If math return true, otherwise false.
     */
    public static Boolean checkMsg(String msg) {
        return pattern.matcher(msg).matches();
    }
}