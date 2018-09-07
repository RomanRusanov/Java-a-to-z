package ru.rrusanov.nonBlockCaсhe;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.09.2018
 *
 * The class describe base model class.
 */
@ThreadSafe
public class Cache {

    private ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    public boolean add(Base model) {
        return this.cache.put(model.getId(), model) == null;
    }
    public boolean update(Base model) throws OptimisticException {
        boolean result = false;
        Base modelInCache = this.cache.get(model.getId());
        if (modelInCache.getVersion() != model.getVersion()) {
            throw new OpimisticException();
        }
        this.cache.computeIfPresent(model.getId(), model,);
        return result;
    }

    public boolean delete(Base model) {
        return this.cache.remove(model.getId(), model);
    }

    BiFunction<>
}
