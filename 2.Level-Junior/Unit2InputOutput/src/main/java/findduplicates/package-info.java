/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.08.2020
 *
 * Search.java The class search files certain extension and print to console
 *  relative path.
 *  public static void main(String[] args) The main method.
 *  public static List<Path> searchDuplicate(Path root)
 *   The method find duplicates file.
 * SearchFiles.java The class implements FileVisitor behavior to walk over files tree
 *  and find duplicate file.
 *  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
 *   Overrated method from FileVisitor class.
 *  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
 *   Overrated method from FileVisitor class.
 *  public FileVisitResult visitFileFailed(Path file, IOException exc)
 *   Overrated method from FileVisitor class.
 *  public FileVisitResult postVisitDirectory(Path dir, IOException exc)
 *   Overrated method from FileVisitor class.
 *  public List<Path> getPaths() The method getter for collection field.
 */
package findduplicates;