package socket;
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
     * The method start server.
     * @throws IOException may throw I/O Exception.
     */
    public void init() throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean work = true;
            while (work) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        Matcher matcher = parseMsg.matcher(str);
                        String msgKey = "";
                        while (matcher.find()) {
                            msgKey = matcher.group(1);
                            String message = this.allMessage.getOrDefault(msgKey, "What");
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(message.getBytes());
                        }
                        if (msgKey.equals("Exit")) {
                            work = false;
                        }
                        str = in.readLine();
                    }
                }
            }
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