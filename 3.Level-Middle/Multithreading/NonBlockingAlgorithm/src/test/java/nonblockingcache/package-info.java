/**
 * NonBlockingCacheTest.java
 *  setup() The method execute before each test.
 *  whenAdd2ModelThenTheyPresentICache()
 *   The test check when add model with different id then they present in cache.
 *  whenIdEqualsAndVersionDifferent1PlusThenUpdateIt()
 *   The test check if try update model with equals id and version different
 *   (current stored +1) then update in cache.
 *  whenIdEqualsAndVersionDifferentNot1PlusThrowException()
 *   The test check if try update model with equals id and version different
 *   not (current stored +1) then throw exception.
 *  whenModelRemovedThenItNotExistInCache()
 *   The test check if model remove from cache, then this model not present.
 */
package nonblockingcache;