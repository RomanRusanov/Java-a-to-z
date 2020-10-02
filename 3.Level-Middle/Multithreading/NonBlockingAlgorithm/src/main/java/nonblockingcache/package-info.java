/**
 * Base.java The class describe model that cache store.
 *  public Base(int id, int version, String data) The default constructor.
 *  public int getId() The getter for field.
 *  public void setId(int id) The setter for field.
 *  public int getVersion() The getter for field.
 *  public void setVersion(int version) The setter for field.
 *  public String getData() The getter for field.
 *  public void setData(String data) The setter for field.
 *  public boolean equals(Object o) The method compare models.
 *  public int hashCode() The method generate hashcode.
 *  public String toString() The method override correct string representation.
 *
 * OptimisticException.java The class implements runtime exception.
 *  public OptimisticException(String s) The default constructor.
 *
 * NonBlockingCache.java The class implements non blocking cache
 *  that store Base instance.
 *  public boolean add(Base model) The method add model to cache.
 *  public boolean update(Base model) The method update model.
 *  public boolean delete(Base model) The method remove model from cache.
 *  public boolean isContain(Base model) The method check if model contain in cache.
 */
package nonblockingcache;