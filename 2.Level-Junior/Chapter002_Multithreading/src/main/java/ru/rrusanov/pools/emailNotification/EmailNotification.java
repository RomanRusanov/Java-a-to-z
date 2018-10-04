package ru.rrusanov.pools.emailNotification;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 4.10.2018
 *
 * The EmailNotification class implement behavior logic sending emails to users,
 * with using concurrent utilities Executor.
 */
public class EmailNotification {
    /**
     * The instance contain pool of threads.
     */
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    /**
     * The method make template subject and bode, and run method send.
     * @param user user to send.
     */
    public void emailTo(User user) {
        String subject = "Notification " + user.getName() + " to email " + user.getEmail();
        String body = "Add a new event to " + user.getName();
        this.pool.submit(new Runnable() {
            @Override
            public void run() {
                send(subject, body, user.getEmail());
            }
        });
    }
    /**
     * The method terminate thread pool.
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
     * The getter for field.
     * @return reference to thread pool.
     */
    public ExecutorService getPool() {
        return this.pool;
    }
    /**
     * The method send message to email.
     * @param subject consumer.
     * @param body of message.
     * @param email address to sent.
     */
    public void send(String subject, String body, String email) {

    }
}
