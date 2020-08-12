/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.08.2020
 *
 * ArgZip.java The class chek args passed in program from console.
 *  public ArgZip(String[] args) The default constructor.
 *  public boolean valid() The method check all args are correct an all present.
 *  public void parse(String[] args)
 *   The method check that two params passed and parse them.
 *  public String directory() The getter for directory param.
 *  public String exclude() The getter for exclude param.
 *  public String output() The getter for output param.
 *
 * Zip.java The class zip files.
 *  public Zip(ArgZip argZip) The default constructor.
 *  public void init() The method start zip process.
 *  public static List<Path> search(Path root, String ext)
 *   The method take root(start) position in file system tree and find all files
 *    besides that extension(ext).
 *  public void packFiles(List<File> sources, File target)
 *   The method zip files passed in list. Store to target zip file.
 *  public static void main(String[] args) Main method.
 */
package arhivateproject;