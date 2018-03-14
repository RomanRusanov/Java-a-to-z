package ru.rrusanov.search;
import java.util.LinkedList;
import java.util.ListIterator;
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
        ListIterator<Task> listIterator = this.tasks.listIterator();
        while (listIterator.hasNext()) {
            int index = listIterator.nextIndex();
            Task current = listIterator.next();
            int positionToAdd = task.getPriority() <= current.getPriority() ? index : ++index;
                while (listIterator.hasNext()) {
                    current = this.tasks.get(index);
                    if (current.getPriority() > task.getPriority()) {
                        positionToAdd = index;
                        break;
                    }
                    index++;
                }
            this.tasks.add(positionToAdd, task);
            break;
        }
        if (this.tasks.isEmpty()) {
            this.tasks.add(0, task);
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
