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

    public TrieTree() {
        this.root = new Node(' ');
    }

    public boolean put(String addWord) {
        boolean result = false;
        Node currentNode = this.root;
        int index = 1;
        for (Character item: addWord.toCharArray()) {
            if (!currentNode.containChildren(item)) {
                currentNode.addChildren(item);
                if (addWord.length() == index ) {
                    currentNode = currentNode.getChildrenNode(item);
                    currentNode.addEndOfWordNode();
                    result = true;
                    break;
                }
            }
            currentNode = currentNode.getChildrenNode(item);
            index++;
        }
        return result;
    }

    public Node search(String searchWord) {
        Node currentNode = this.root;
        Node result = null;
        for (Character item: searchWord.toCharArray()) {
            if (!currentNode.containChildren(item)) {
                return null;
            }
            currentNode = currentNode.getChildrenNode(item);
        }
        currentNode = currentNode.getChildrenNode(' ');
        if (currentNode.isWord()) {
            result = currentNode;
        }
        return result;
    }

}
