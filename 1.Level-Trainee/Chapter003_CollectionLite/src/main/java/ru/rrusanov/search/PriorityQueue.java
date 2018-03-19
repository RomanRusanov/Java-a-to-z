package ru.rrusanov.search;
import java.util.LinkedList;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 03.03.2018
 *
 * Class define PriorityQueue.
 */
public class PriorityQueue {
    /**
     * Collection contain all task.
     */
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        boolean positionFind = false;
        for (int i = 0; i < this.tasks.size(); i++) {
            if (task.getPriority() < this.tasks.get(i).getPriority()) {
                this.tasks.add(i, task);
                positionFind = true;
                break;
            }
        }
        if (!positionFind) {
            this.tasks.add(this.tasks.size(), task);
        }
    }
    /**
     * Get last task and remove from collection.
     * @return Task.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
