package ru.rrusanov.collection.simpleArrayList;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.2018
 *
 * SimpleArrayList class. Single linked list.
 * @param <E> generic type.
 */
public class SimpleArrayList<E> {
    /**
     * The field size of collection.
     */
    private int size;
    /**
     * The field contain link to last added element.
     */
    private Node<E> first;
    /**
     * Unique index start from zero, add to each node when create new instance of node.
     */
    private int indexInList;
    /**
     * Default constructor.
     */
    public SimpleArrayList() {

    }
    /**
     * Constructor add node when instance create.
     * @param node first node in collection.
     */
    public SimpleArrayList(Node<E> node) {
        this.first = node;
        this.first.index = 0;
        this.indexInList = 0;
        this.size++;
    }
    /**
     * The method insert data at beginning list.
     * @param date new element to adding in collection.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        newLink.index = ++this.indexInList;
        this.first = newLink;
        this.size++;
    }
    /**
     * Implements The method deleting first element in list.
     * @return deleted element.
     */
    public E delete() {
        Node<E> wasFirst = first;
        this.first = first.next;
        this.size--;
        return wasFirst.date;
    }
    /**
     * The method remove node from collection with index.
     * @param index node to remove.
     * @return data in removed node.
     */
    public E delete(int index) {
        return this.deleteNode(index).date;
    }
    /**
     * The method remove node from collection with index.
     * @param index node to remove.
     * @return removed node.
     */
    public Node<E> deleteNode(int index) {
        Node<E> previousNode = this.getNode(index - 1);
        Node<E> deletedNode = this.getNode(index);
        Node<E> afterNode = this.getNode(index + 1);
        previousNode.next = afterNode;
        if (index == 0) {
            this.first = afterNode;
        }
        this.size--;
        return deletedNode;
    }
    /**
     * The method get element using index to find.
     * @param index element to get.
     * @return element.
     */
    public E get(int index) {
        return this.getNode(index).date;
    }
    /**
     * The method return node from collection.
     * @param index node to return.
     * @return node at specific index position.
     */
    public Node<E> getNode(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }
    /**
     * The method return size of list.
     * @return int size of collection.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * The method check contain collection cycling sequence.
     * @param first Node to start position to check.
     * @return True if sequence exist, otherwise return false.
     */
    boolean hasCycle(Node<E> first) {
        boolean result = false;
        boolean checkComplete = false;
        int i = 0;
        while (!checkComplete) {
            try {
                Node<E> current = getNode(first.index + i);
                Node<E> next = getNode(first.index + i + 1);
                i++;
                if (current.index < next.index) {
                    result = true;
                    checkComplete = true;
                }
            } catch (RuntimeException e) {
                break;
            }
        }
        return result;
    }
}
