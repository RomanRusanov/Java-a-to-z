package threadwithoutsharedresources;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * Не важно что будет происходить с объектом внутри других потоков, объект
 * который храниться в кэше останется не измененым т.к в колекцию добавляется
 * новый instance но с тем же именем.
 */
public class ShareNotSafe {
    /**
     * The main method.
     * @param args Passed params.
     * @throws InterruptedException join may throw.
     */
    public static void main(String[] args) throws InterruptedException {
        UserCache cache = new UserCache();
        User user = User.of("name");
        cache.add(user);
        Thread first = new Thread(
                () -> {
                    user.setName("rename");
                }
        );
        Thread second = new Thread(
                () -> {
                    user.setName("rename 2");
                }
        );
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(cache.findById(1).getName()); // всегда будет "name"
    }
}