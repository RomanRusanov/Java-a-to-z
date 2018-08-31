/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.08.2018
 *
 *  The SimpleBlockingQueue.java class describe behavior collection with blocking bounded queue.
 *   void offer(T value) The method add value in queue.
 *   T poll() The method retire element from queue, and return them.
 *   void setProducerStop(boolean value) The method setter.
 *   boolean getProducerStop() The method getter.
 *
 *  The ParallelSearch.java class show behavior two threads(producer and consumer) when producer stop,
 *   then consumer thread terminate.
 */
package ru.rrusanov.waitNotifyNotifyAll.parallelSearch;