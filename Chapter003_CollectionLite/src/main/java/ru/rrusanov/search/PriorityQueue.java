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
        Task current;
        int index;
        int positionToAdd;
        while (listIterator.hasNext()) {
            index = listIterator.nextIndex();
            current = listIterator.next();
            if (task.getPriority() <= current.getPriority()) {
                positionToAdd = index;
            } else {
                positionToAdd = ++index;
            }
            ListIterator<Task> listIteratorIn = this.tasks.listIterator(index);
            if (listIteratorIn.hasNext()) {
                while (listIteratorIn.hasNext()) {
                    index = listIteratorIn.nextIndex();
                    current = listIteratorIn.next();
                    if (current.getPriority() > task.getPriority()) {
                        positionToAdd = index;
                        break;
                    }
                }
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
