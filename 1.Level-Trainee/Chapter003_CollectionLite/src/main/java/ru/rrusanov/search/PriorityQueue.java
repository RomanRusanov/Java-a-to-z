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
        int positionToAdd = 0;
        for (int i = 0; i < this.tasks.size(); i++) {
            if (task.getPriority() <= this.tasks.get(i).getPriority()) {
                positionToAdd = i;
                break;
            } else {
                positionToAdd = ++i;
                break;
            }
        }
        if (this.tasks.size() > positionToAdd) {
            for (int j = positionToAdd; j < this.tasks.size(); j++) {
                if (this.tasks.get(j).getPriority() > task.getPriority()) {
                    positionToAdd = j;
                    break;
                }
            }
        }
        positionToAdd = this.tasks.isEmpty() ? 0 : positionToAdd;
        this.tasks.add(positionToAdd, task);
    }
    /**
     * Get last task and remove from collection.
     * @return Task.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
