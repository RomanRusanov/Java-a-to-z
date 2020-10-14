/**
 *
 * Parser.java The class parse file from disk and run some async process.
 *  public Parser(ToServer toServer, ToDB toDB, ToFiles toFiles, Config config)
 *   The default constructor.
 *  public static Set<Map.Entry<String, String[]>> getEntrySet()
 *   The getter for collection field.
 *  public void reader() The method parse data in HashMap countries.
 *  public boolean isValidRecord(String currentLine)
 *   The method chek string match pattern regex.
 *  public void init() The method start async work.
 *  public boolean isWorkComplete() The method check all task complete.
 *  public static String getCountryName(String record)
 *   The method parse string and get group 3 in regex.
 *  public static String getRatingValue(String record)
 *   The method parse string and get group 4 in regex.
 *  public static String getFirstName(String record)
 *   The method parse string and get group 1 in regex.
 *  public static String getLastName(String record)
 *   The method parse string and get group 2 in regex.
 *  public static void main(String[] args) The main method.
 *
 * ToFiles.java The class take from parse collection and store on disk.
 *  public ToFiles(Config config) The default constructor.
 *  public CompletableFuture<Boolean> writeToDisk() The method start async process.
 *
 * ToDB.java The class take from parse collection and insert in DB.
 *  ToDB(Config config, boolean rollback) The default constructor.
 *  public Connection getConnection() The method get current connection for test.
 *  public Connection initConnection() The method create connection to db.
 *  public CompletableFuture<Boolean> insertInDB() The method start async process.
 *  public void close() Closes connection resource.
 *
 * ToServer.java The class take from parse collection and send to server.
 *  public ToServer(Config config) The default constructor.
 *  public CompletableFuture<Void> initClient() The method start async process.
 *  public CompletableFuture<Boolean> initServer() The method start async process.
 *  public Integer getCollectionSize() The getter for collection size.
 */
package completablefuture;