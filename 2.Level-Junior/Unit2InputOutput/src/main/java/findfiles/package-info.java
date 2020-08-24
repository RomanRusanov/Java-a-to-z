/**
 * ArgsName.java The class parse parameters passed as arguments and put them
 *  to collection.
 *  public String get(String key) The method get value by passed key string.
 *  private void parse(String[] args) The method check that seven params
 *   passed and parse them.
 *  FileNameOperation.java The class Compare passed file name.
 *   Must be fully identical.
 *   public String getKey() The method return key of operation.
 *   public boolean fileMathCondition(Path file, ArgsName args)
 *    The method implements logic how compare.
 *  Find.java The class find files by condition.
 *   public static void main(String[] args) The main method.
 *   public void process(ArgsName argsName) The method start all process.
 *   public void addOperations(OperationOnFiles operation)
 *    The method add operation to collection.
 *   public void fillOperations()
 *    The method fill collection with all operations.
 *   public List<Path> search(
 *             Path root,
 *             OperationOnFiles operation,
 *             ArgsName argsName
 *             )
 *             The method find in all included sub folders.
 *              Use FileVisitor instance.
 *   public void save(List<Path> log, String file)
 *    The method save in file all found path with filenames.
 *  MaskOperation.java The class check if file math by passed mask.
 *   public String getKey() The method return key of operation.
 *    The method return key of operation.
 *   public boolean fileMathCondition(Path file, ArgsName args)
 *    The method implements logic how compare.
 *   public void getPattern(String parsedMask)
 *    The method generate pattern for regex.
 *  OperationOnFiles.java The interface implements operation how search file.
 *   String getKey() The method return key value.
 *   boolean fileMathCondition(Path file, ArgsName args)
 *    The method implements logic how compare.
 *  RegexOperation.java The class check if file math by passed regex.
 *   public String getKey() The method return key of operation.
 *   public boolean fileMathCondition(Path file, ArgsName args)
 *    The method implements logic how compare.
 *   public void getPattern(String regex)
 *    The method generate pattern for regex.
 *  SearchFiles.java The class implements FileVisitor behavior to walk
 *   over files tree and find duplicate file.
 *   public SearchFiles(OperationOnFiles operation, ArgsName argsName)
 *    Default constructor.
 *   public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
 *    Overrated method from FileVisitor class.
 *   public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
 *    Overrated method from FileVisitor class.
 *   public FileVisitResult visitFileFailed(Path file, IOException exc)
 *    Overrated method from FileVisitor class.
 *   public FileVisitResult postVisitDirectory(Path dir, IOException exc)
 *    Overrated method from FileVisitor class.
 *   public List<Path> getPaths() The method getter for collection field.
 */
package findfiles;