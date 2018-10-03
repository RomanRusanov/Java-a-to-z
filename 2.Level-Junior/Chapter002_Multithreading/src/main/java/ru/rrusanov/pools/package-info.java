/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 3.10.2018
 *
 * ThreadPool.java class implements simple thread pool behavior.
 *  public void work(Runnable job) The method add task to pool.
 *  public void initPool() The method initiate thread pool. Number of thread use all available core on CPU.
 *  public void shutdown() The method terminate all thread in pool. Without wait until thread complete tasks in queue.
 *  public List<Thread> getThreads() The getter for field.
 */
package ru.rrusanov.pools;