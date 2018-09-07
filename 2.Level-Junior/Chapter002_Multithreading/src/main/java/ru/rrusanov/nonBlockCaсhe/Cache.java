package ru.rrusanov.nonBlockCaсhe;
import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.ConcurrentHashMap;
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
        return ;
    }

    public boolean update(Base model) {
        return false;
    }

    public boolean delete(Base model) {
        return false;
    }


}
