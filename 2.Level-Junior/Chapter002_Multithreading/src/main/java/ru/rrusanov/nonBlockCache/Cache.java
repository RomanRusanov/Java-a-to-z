package ru.rrusanov.nonBlockCache;
import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.09.2018
 *
 * The class describe nonBlockCache blocking cache.
 */
@ThreadSafe
public class Cache {
    /**
     * The field contain collection.
     */
    private ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();
    /**
     * The method add model in collection.
     * @param model to add.
     * @return return if add success, otherwise false.
     */
    public boolean add(Base model) {
        return this.cache.put(model.getId(), model) == null;
    }
    /**
     * The method update entry in collection if version not equals with updated when entry be update other thread
     * and need throws exception.
     * @param model Model that be read early, now need update.
     * @throws OptimisticException throw if version not equals.
     */
    public void update(Base model) throws OptimisticException {
        Base modelInCacheToUpdate = this.cache.get(model.getId());
        if (modelInCacheToUpdate.getVersion() != model.getVersion()) {
            throw new OptimisticException("Data all ready updated!");
        }
        this.cache.computeIfPresent(model.getId(), (modelUpdated, modelInCache) -> {
            modelInCache = modelInCacheToUpdate;
            modelInCache.setName(model.getName());
            modelInCache.setVersion(modelInCache.getVersion() + 1);
            return modelInCache;
        });
    }
    /**
     * The method remove model from collection.
     * @param model to delete.
     */
    public void delete(Base model) {
        this.cache.remove(model.getId(), model);
    }
    /**
     * The method get model from collection.
     * @param key value, to find.
     * @return Base model.
     */
    public Base get(Integer key) {
        return this.cache.get(key);
    }
    /**
     * The method find model in collection.
     * @param model to find.
     * @return return true if collection contain that model, otherwise false.
     */
    public boolean contains(Base model) {
        return this.cache.contains(model);
    }
}
