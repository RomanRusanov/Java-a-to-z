/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.08.2020
 *
 * Config.java The class read config from file from defined path.
 *  Config expect param=value. Pairs config store at HashMap key-param, value-value.
 *  public Config(final String path) The default constructor.
 *  public void load() The method read from file lines (param=value)
 *   and put to collection values.
 *  public boolean isContain(String source)
 *   The method compile regex, and chek string match pattern regex.
 *  public String value(String key)
 *   The method return value from collection by passed key.
 *  public String toString() The method override toString.
 *  public static void main(String[] args) Main method.
 */
package readfileconfiguration;