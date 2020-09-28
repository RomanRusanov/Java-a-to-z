package javamemorymodel;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * 1. Ниже приведен код синглтона - double check locking.
 * 2. Исправьте в нем ошибку. Текстом в комментарии напишите,
 *    почему возникает ошибка.
 * 3. Загрузите код в репозиторий. Оставьте ссылку на коммит.
 */
public final class DCLSingleton {
    /**
     * The field contain instance.
     */
    private static DCLSingleton inst;

    /**
     * The method generate instance of class.
     * @return DCLSingleton.
     */
    public synchronized static DCLSingleton instOf() {
        if (inst == null) {
            synchronized (DCLSingleton.class) {
                if (inst == null) {
                    inst = new DCLSingleton();
                }
            }
        }
        return inst;
    }

    /**
     * The default constructor.
     */
    private DCLSingleton() {
    }
}