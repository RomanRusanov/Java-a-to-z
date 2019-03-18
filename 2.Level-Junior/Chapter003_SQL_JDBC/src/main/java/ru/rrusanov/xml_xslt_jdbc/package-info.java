/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.03.2019
 *
 * Config.java Class create connection to SQLite db.
 *  void init() The method load properties from file app.propertiesSqlLite.
 *  boolean initConnectionToSQLiteDB() Method create instance of connection of db if it not exist yet.
 *  Connection getConnection() The method return connection instance to DB.
 *
 * ConvertXSQT.java Class convert xml to other xml structure.
 *  void convert(File source, File dest, File scheme) The method convert from dest xml file to source xml file,
 *   using scheme xsl file.
 *  void parse(File source) The method parse to System.out sum all entries element.
 *
 * Entries.java Class describe entries.
 *  List<Entry> getEntry() Getter for field.
 *  void setEntry(List<Entry> entry) Setter for field.
 *
 * Entry.java Class describe entry.
 *  int getField() Getter for field.
 *  void setField(int field) Setter for field.
 *  boolean equals(Object o) The method compare to entry obj.
 *  int hashCode() The method return hashcode of entry.
 *
 * StoreSQL.java Class generate in SQLite DB sequence of rows.
 *  void generate(int size) The method generate sequence of rows in db.
 *  void clearTable() The method clear table entry from all rows.
 *  List<Entry> load() The method load from DB to collection all entry that exist in table entry.
 *  boolean tableExist(String tableName) The method check exist table in db.
 *  void createTable() The method create table entry in DB.
 *  void deleteTable() The method delete entry table from DB.
 *  void close() Closes this resource, relinquishing any underlying resources.
 *
 * StoreXML.java Class convert Entry object into xml structure.
 *  void save(List<Entry> list) The method save Entries from collection to xml file.
 */
package ru.rrusanov.xml_xslt_jdbc;