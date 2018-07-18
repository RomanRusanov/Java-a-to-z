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
        Node currentNode = root;
        int index = 0;

        for (Character item: addWord.toCharArray()) {

            if (!currentNode.containChildren(item)) {
                currentNode.addChildren(item);

                if (addWord.length() == index) {
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

}
