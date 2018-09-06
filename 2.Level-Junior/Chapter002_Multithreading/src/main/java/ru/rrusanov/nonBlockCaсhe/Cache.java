package ru.rrusanov.nonBlockCaсhe;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.rrusanov.nonBlockCaсhe.Base;

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


}
