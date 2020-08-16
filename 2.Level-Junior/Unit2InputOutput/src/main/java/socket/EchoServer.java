package socket;
import logger.UsageLog4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.08.2020
 * email roman9628@gmail.com
 * The class send and receive simple http packets.
 * If Server receive string contain "msg=Exit" then server shutdown.
 */
public class EchoServer {
    /**
     * The compiled pattern.
     */
    private Pattern parseMsg = Pattern.compile(".*msg=([A-z]+)\\s.*");
    /**
     * The field contian collection that store all words.
     */
    private HashMap<String, String> allMessage = new HashMap<>();
    /**
     * The instance with logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    /**
     * The method start server.
     * @throws IOException may throw I/O Exception.
     */
    public void init() {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean work = true;
            while (work) {
                Socket socket = null;
                try {
                    socket = server.accept();
                } catch (IOException e) {
                    LOG.error("Error! Get socket from instance server.", e);
                }
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = null;
                    try {
                        str = in.readLine();
                    } catch (IOException e) {
                        LOG.error("Error! Read from buffered reader.", e);
                    }
                    while (!str.isEmpty()) {
                        Matcher matcher = parseMsg.matcher(str);
                        String msgKey = "";
                        while (matcher.find()) {
                            msgKey = matcher.group(1);
                            String message = this.allMessage.getOrDefault(msgKey, "What");
                            try {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write(message.getBytes());
                            } catch (IOException e) {
                                LOG.error("Error! Write to output stream.", e);
                            }
                        }
                        if (msgKey.equals("Exit")) {
                            work = false;
                        }
                        str = in.readLine();
                    }
                } catch (IOException e) {
                    LOG.error("Error! Get input/output stream.", e);
                }
            }
        } catch (IOException e) {
            LOG.error("Error! Create instane ServerSocket.", e);
        }
    }

    /**
     * The method add key word and answer.
     * @param request key message that server parse (http://localhost:9000/?msg=Hello>)
     *                Hello - that key word.
     * @param answer String return by passed key.
     */
    public void addMessage(String request, String answer) {
        this.allMessage.put(request, answer);
    }

    /**
     * The method fill collection all pairs.
     */
    public void fillMessageKeyWords() {
        this.addMessage("Hello", "Hello, dear friend.");
        this.addMessage("Exit", "Good bay my friend!");
        this.addMessage("What", "What?");
    }

    /**
     * The main method.
     * @param args String args.
     * @throws IOException may throw I/O Exception.
     */
    public static void main(String[] args) throws IOException {
        EchoServer echoServer = new EchoServer();
        echoServer.init();
    }
}