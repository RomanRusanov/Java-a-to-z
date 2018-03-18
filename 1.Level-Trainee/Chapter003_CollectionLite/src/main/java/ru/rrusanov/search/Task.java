package ru.rrusanov.search;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 03.03.2018
 *
 * Class define Task.
 */
public class Task {
    /**
     * Description of task.
     */
    private String desc;
    /**
     * Priority that task.
     */
    private int priority;
    /**
     * Default constructor.
     * @param desc Description.
     * @param priority Priority.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }
    /**
     * Getter for description field.
     * @return String.
     */
    public String getDesc() {
        return desc;
    }
    /**
     * Getter for priority field.
     * @return int Priority value.
     */
    public int getPriority() {
        return priority;
    }
}
