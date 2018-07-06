package ru.rrusanov.tree;

import java.util.*;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.07.2018
 *
 *
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;

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
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private List<Node<E>> sequence = new ArrayList<>();

            private int failFast;

            private int index = 0;

            @Override
            public boolean hasNext() throws ConcurrentModificationException {
                boolean result = false;
                this.sequenceToIterate();
                if (failFast != sequence.size()) {
                    throw new ConcurrentModificationException("Tree mutate not accepted!");
                }
                if (index <= sequence.size() - 1) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException{
                if (this.hasNext()) {
                    return sequence.get(index++).getValue();
                }
                throw new NoSuchElementException("No more elements to iterate!");
            }

            public void sequenceToIterate() {
                Queue<Node<E>> data = new LinkedList<>();
                data.offer(root);
                while (!data.isEmpty()) {
                    Node<E> el = data.poll();
                    if (!sequence.contains(el)) {
                        this.sequence.add(el);
                    }
                    for (Node<E> child : el.leaves()) {
                        data.offer(child);
                    }
                }
                this.failFast = sequence.size();
            }
        };
    }
}
