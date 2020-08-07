/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.08.2020
 *
 * Analizy.java The class Analyze text log and
 *  find periods when server down and up.
 *  public void unavailable(String source, String target)
 *   The method star all process. Load. Save.
 *  public void load(String pathServerLog) The method read from file lines
 *  public void processLine(String[] twoStrings) Check line and store to collection.
 *  public static void save(List<String> log, String file)
 *   The method save list to file on disk.
 *  public boolean isContain(String source)
 *   The method compile regex, and chek string match pattern regex.
 *  public static void main(String[] args) The main method.
 */
package checkserveraccessibility;