package ru.rrusanov.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.07.2018
 *
 *
 */
public class SimpleTreeTest {

    @Test
    public void add() {
    }

    @Test
    public void findBy() {
    }

    @Test
    public void iterator() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> iterator = tree.iterator();
        iterator.hasNext();
        tree.findBy(1);
    }

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
}