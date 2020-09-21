package cache;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * 1. Ниже приведен код. Это код содержит ошибку атомарности.
 * Поправьте код, загрузите изменения в github.
 */
public final class Cache {
    /**
     * The filed contain instance.
     */
    private static Cache cache;

    /**
     * The method return new instance.
     * @return Cache instance.
     */
    public static synchronized Cache instOf() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}