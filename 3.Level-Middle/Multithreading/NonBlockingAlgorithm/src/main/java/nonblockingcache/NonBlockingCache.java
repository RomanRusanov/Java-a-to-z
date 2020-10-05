package nonblockingcache;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 01.10.2020
 * email roman9628@gmail.com
 * The class implements non blocking cache that store Base instance.
 */
@ThreadSafe
public class NonBlockingCache {
    /**
     * The field contain map that store all models.
     */
    private final ConcurrentHashMap<Integer, Base> storedBase = new ConcurrentHashMap<>();

    /**
     * The method add model to cache. If passed model id exist in cache.
     * Then passed model rewrite data and version stored model in cache.
     * @param model Model to add.
     * @return If model added return true.
     */
    public boolean add(Base model) {
        this.storedBase.put(model.getId(), model);
        return this.storedBase.containsKey(model.getId());
    }

    /**
     * The method update model. Model with equals id's and version must
     * different (in passed model (current stored version +1)), if version equals
     * or different more then +1 method throw OptimisticException. If passed model
     * not exist in cache throw IllegalArgumentException.
     * @param model Model to update.
     * @return If model update return true, otherwise false.
     */
    public boolean update(Base model) {
        final AtomicReference<Base> atomicReference = new AtomicReference<>();
        if (!this.storedBase.containsKey(model.getId())) {
            throw new IllegalArgumentException(
                    "Base mode: " + model + " not exist in cache!"
            );
        }
        this.storedBase.computeIfPresent(model.getId(),
                (key, base) -> {
                    atomicReference.set(this.storedBase.get(key));
                    if (atomicReference.get().getVersion() != (model.getVersion() - 1)) {
                        throw new OptimisticException("Version model passed "
                                + "different from expect, possible data corruption!"
                        );
                    }
                    atomicReference.set(model);
                    return atomicReference.get();
                }
        );
        return true;
    }

    /**
     * The method remove model from cache.
     * @param model Model to remove.
     * @return If removed return true, otherwise false.
     */
    public boolean delete(Base model) {
        return this.storedBase.remove(model.getId(), model);
    }

    /**
     * The method check if model contain in cache.
     * @param model Model to find.
     * @return If present return true, otherwise false.
     */
    public boolean isContain(Base model) {
        return this.storedBase.containsValue(model);
    }
}