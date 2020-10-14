package completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.10.2020
 * email roman9628@gmail.com
 * The class take from parse collection and send to server.
 */
public class ToServer {
    /**
     * The instance with logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ToServer.class.getName());
    /**
     * The filed contain collection that receive server from client.
     */
    private final Map<String, List<String>> countriesFromParser = new HashMap<>();
    /**
     * The filed contain address for client.
     */
    private final String serverAddress;
    /**
     * The filed contain port number for server and client use.
     */
    private final int clientAndServerPort;
    /**
     * The field contain instance with config params pairs.
     */
    private final Config config;

    /**
     * The default constructor.
     * @param config Config instance.
     */
    public ToServer(Config config) {
        this.config = config;
        this.clientAndServerPort = Integer.parseInt(config.value("port"));
        this.serverAddress = config.value("addressServer");
    }

    /**
     * The method start async process. Open connection socket to server, and send
     * all data from parse collection to server.
     * @return Void.
     */
    public CompletableFuture<Void> initClient() {
        return CompletableFuture.runAsync(() -> {
            Socket clientSocket = null;
            try {
                clientSocket = new Socket(serverAddress, clientAndServerPort);
            } catch (IOException e) {
                LOG.error("Error! Get socket from client.", e);
            }
            if (clientSocket != null && clientSocket.isConnected()) {
                try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                        (clientSocket.getOutputStream())))) {
                    for (Map.Entry<String, String[]> entry : Parser.getEntrySet()) {
                        String[] records = entry.getValue();
                        for (String s : records) {
                            out.println(s);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                LOG.error(String.format("Error! Not connected to server:%s port:%d",
                        serverAddress, clientAndServerPort));
            }
            LOG.info("Client work complete!");
        });
    }

    /**
     * The method start async process. Open server socket, and store
     * received data from client in local collection countriesFromParser.
     * @return Void.
     */
    public CompletableFuture<Boolean> initServer() {
        return CompletableFuture.supplyAsync(() -> {
            try (ServerSocket server = new ServerSocket(clientAndServerPort)) {
                Socket socket = null;
                try {
                    socket = server.accept();
                    LOG.info(String.format("Connected to server from:%s port:%d",
                            socket.getInetAddress().getCanonicalHostName(), socket.getPort()));
                } catch (IOException e) {
                    LOG.error("Get socket from instance server.", e);
                }
                if (socket != null) {
                    try (BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {
                        String str = in.readLine();
                        try {
                            while (str != null) {
                                String country = Parser.getCountryName(str);
                                if (!this.countriesFromParser.containsKey(country)) {
                                    this.countriesFromParser.put(country, new ArrayList<>());
                                }
                                this.countriesFromParser.get(country).add(str);
                                str = in.readLine();
                            }
                        } catch (IOException e) {
                            LOG.error("Read from buffered reader.", e);
                        }
                    } catch (IOException e) {
                        LOG.error("Get input/output stream.", e);
                    }
                } else {
                    LOG.error("Socket is NULL!");
                }
            } catch (IOException e) {
                LOG.error("Create instance ServerSocket.", e);
            }
            LOG.info(String.format("Server store:%d entry.", this.countriesFromParser.size()));
            return true;
        });
    }

    /**
     * The getter for collection size.
     * @return Integer value.
     */
    public Integer getCollectionSize() {
        return this.countriesFromParser.size();
    }
}