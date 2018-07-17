package ru.rrusanov.tree;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.07.2018
 *
 * The class Tree.java stored elements in tree of node elements.
 * @param <E> generic type that collection stored.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * The field contain first node(root).
     */
    private Node<E> root;
    /**
     * The default constructor.
     * @param root first node.
     */
    public Tree(Node<E> root) {
        this.root = root;
    }
    /**
     * Added element child in parent.
     * Parent may have list of child.
     *
     * @param parent parent.
     * @param child  child.
     * @return If added when return true, otherwise false.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentNode = this.findBy(parent);
        if (parentNode.isPresent()) {
            parentNode.get().add(new Node<>(child));
            result = true;
        }
        return result;
    }
    /**
     * The method find in tree collection node with passed value, and return them wrapped Optional class(can create
     * empty instance of Node<E>).
     * @param value that node store.
     * @return if collection contain Node with that value then return Node<E>, otherwise return Optional.empty.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                result = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }
    /**
     * Returns an iterator over elements of type Node<E>. Behavior fastFail not implemented because sequenceToIterate
     * (immutable) create then instance iterator create and not update after call next or hashNext method.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * The field contain sequence of element to iterate.
             */
            private List<Node<E>> sequenceToIterate = this.sequenceToIterate();
            /**
             * The field contain index counter current element witch return.
             */
            private int index = 0;
            /**
             * The method check has collection more element to iterate.
             * @return If not all element passed then return true, otherwise return false.
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                this.sequenceToIterate();
                if (index <= sequenceToIterate.size() - 1) {
                    result = true;
                }
                return result;
            }
            /**
             * The method return next element in collection.
             * @return Node<E> element.
             * @throws NoSuchElementException If no more element to iterate and call next then throw exception.
             */
            @Override
            public E next() throws NoSuchElementException {
                if (!this.hasNext()) {
                    throw new NoSuchElementException("No more elements to iterate!");
                }
                return sequenceToIterate.get(index++).getValue();
            }
            /**
             * The method build sequence element of Node<E> and return as ArrayList.
             * @return all nodes in tree collection.
             */
            public ArrayList<Node<E>> sequenceToIterate() {
                Queue<Node<E>> data = new LinkedList<>();
                ArrayList<Node<E>> sequence = new ArrayList<>();
                data.offer(root);
                while (!data.isEmpty()) {
                    Node<E> el = data.poll();
                    if (!sequence.contains(el)) {
                        sequence.add(el);
                    }
                    for (Node<E> child : el.leaves()) {
                        data.offer(child);
                    }
                }
                return sequence;
            }
        };
    }
    /**
     * The method check is tree structure binary.
     * @return If tree binary return true, otherwise false.
     */
    public boolean isBinary() {
        boolean result = true;
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            Node<E> itemIterator = this.findBy(iterator.next()).get();
            if (itemIterator.leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }
}
