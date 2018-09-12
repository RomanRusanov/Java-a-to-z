package ru.rrusanov.collection.tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.07.2018
 *
 * The class Node.java implements node element for Tree.java class.
 * @param <E> generic type that collection stored.
 */
public class Node<E extends Comparable<E>> implements Comparable<E> {
    /**
     * The field store all lower level nodes(children).
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * The field store data of current node.
     */
    private final E value;
    /**
     * The default constructor.
     * @param value Data to store in that node.
     */
    public Node(final E value) {
        this.value = value;
    }
    /**
     * The method get data from value field.
     * @return value data(generic).
     */
    public E getValue() {
        return value;
    }
    /**
     * The method add lower level node.
     * @param child Node to add.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }
    /**
     * The method return all nodes low level(children).
     * @return List of nodes low level
     */
    public List<Node<E>> leaves() {
        return this.children;
    }
    /**
     * The method implement Comparable interface, compare stored data value in nodes.
     * @param value passed to compare.
     * @return If this value stored in node greater them passed then return 1,
     * if smaller return -1, if equals return 0.
     */
    @Override
    public int compareTo(E value) {
        return this.value.compareTo(getValue());
    }
    /**
     * The method compare data value.
     * @param that passed data value.
     * @return If stored value equals return true, otherwise false.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
    /**
     * The method override equals method. Compare field value and children.
     * Children convert to array and compare by each element.
     * @param obj passed node.
     * @return result.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Node<E> objNode = (Node<E>) obj;
        Node<E>[] childrenArray = (Node<E>[]) new Node[this.children.size()];
        this.children.toArray(childrenArray);
        Node<E>[] objNodeArray = (Node<E>[]) new Node[objNode.children.size()];
        objNode.children.toArray(objNodeArray);
        return this.value.equals(objNode.value) && Arrays.equals(childrenArray, objNodeArray);
    }
    /**
     * The method return hashcode of node.
     * @return int hashcode value.
     */
    @Override
    public int hashCode() {
        int result = 0;
        if (this.value != null) {
            result = this.value.hashCode();
        }
        if (!this.children.isEmpty()) {
            Node<E>[] childrenArray = (Node<E>[]) new Node[this.children.size()];
            this.children.toArray(childrenArray);
            result = Arrays.hashCode(childrenArray);
        }
        return result * 31;
    }
}
