/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.03.2019
 *
 * ConfigTest.java test behavior Config class.
 *  void setUp() The method execute before each test.
 *  void whenPropertiesSetThenReturnThem() Test init method.
 *
 * ConvertXSQTTest.java test behavior ConvertXSQT class.
 *  void setUp() The method execute before each test.
 *  void closeConnection() The method execute after each test.
 *  void whenPassXmlAndSchemeThenGetAnotherXML() Test method convert.
 *  void whenPassXmlThenGetSumAllElements() Test method parse.
 *
 * StoreSQLTest.java Class test behavior StoreSQL class.
 *  void setUp() The method execute before each test.
 *  void closeConnection() The method execute after each test.
 *  void whenTableExistThenReturnTrue() Test method tableExist.
 *  void whenTableCreateThenReturnTrue() Test method createTable.
 *  void whenRowsGeneratedThenRowCountEquals() Test method generate.
 *  void whenEntryLoadedThenSizeEquals() Test method load.
 *  void whenMethodCallThenConnectionCreate() Test initConnectionToSQLiteDB method.
 *  void closeConnection() The method execute after each test.
 *
 * StoreXMLTest.java test behavior StoreXML class.
 *  void closeConnection() The method execute after each test.
 *  void whenMethodPassThenStoreToXml() Test method save.
 */
package ru.rrusanov.xml_xslt_jdbc;