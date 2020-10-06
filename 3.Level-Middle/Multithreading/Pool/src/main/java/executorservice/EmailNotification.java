package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.10.2020
 * email roman9628@gmail.com
 * The class implements notification service.
 */
public class EmailNotification {
    /**
     * The field contain thread pool instance.
     * Each time call emailTo(User) pool activate.
     */
    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());

    /**
     * The method format subject and body stings and call send method. In
     * each call make new thread in pool, and call method send.
     * @param user User instance to notified.
     */
    public void emailTo(User user) {
        String subject = String.format("Notification {%s} to email {%s}.",
                user.getUserName(), user.getEmail()
        );
        String body = String.format("Add a new event to {username}",
                user.getUserName()
        );
        this.pool.submit(() -> {
            this.send(subject, body, user.getEmail());
        });
    }

    /**
     * The method shutdown Thread pool.
     */
    public void close() {
        this.pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * The method send message.
     * @param subject Sting with subject email.
     * @param body String with body email.
     * @param email String address email.
     */
    public void send(String subject, String body, String email) {
    }
}