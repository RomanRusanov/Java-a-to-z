package ru.rrusanov.simpleArrayList;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.2018
 *
 * SimpleArrayList class. Single linked list.
 */
public class SimpleArrayList<E> {

    private int size;

    private Node<E> first;

    /**
     * The method insert data at beginning list.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }
    /**
     * Implements The method deleting first element in list.
     */
    public E delete() {
        return null;
    }
    /**
     * The method get element using index to find.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }
    /**
     * The method return size of list.
     */
    public int getSize() {
        return this.size;
    }
}
