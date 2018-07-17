package ru.rrusanov.wordIndex;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2018
 *
 *
 */
public class TrieTree {

    private Node root;

    public boolean put(String string) {
        boolean result = false;
        Node current = root;
        for (Node item: current.getAllChildren()) {
            if (current.containChildren(item)) {

            }
        }
        return result;
    }
}
