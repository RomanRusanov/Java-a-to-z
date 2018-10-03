/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 3.10.2018
 *
 * ThreadPoolTest.java class test thread pool behavior.
 *  void setUp() Section executes before each test.
 *  void whenWorkPoolCompleteThenStateFieldChange() Test work method.
 *  void whenInitPoolThenListOfThreadEqualsNumbersOfCores() Test pool use all cores cpu in host.
 *  void whenPoolShutdownThenAllThreadsTerminate() Test shutdown method.
 *
 * Task.java The class describe task.
 *  void run() Thread work.
 *  String getTest() The getter for field.
 */
package ru.rrusanov.pools;