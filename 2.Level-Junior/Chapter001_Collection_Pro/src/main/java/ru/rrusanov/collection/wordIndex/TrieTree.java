package ru.rrusanov.collection.wordIndex;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2018
 *
 * The Class describes classic Trie tree collection.
 */
public class TrieTree {
    /**
     * The field contain root reference of tree.
     */
    private Node root;
    /**
     * Default constructor. Make root with char ' ' (space)
     */
    public TrieTree() {
        this.root = new Node(' ');
    }
    /**
     * The method add word to tree, smashing in to char sequence.
     * @param addWord word to add.
     * @param position position in file passed word.
     * @return true if word added, otherwise false.
     */
    public boolean put(String addWord, int position) {
        boolean result = false;
        Node currentNode = this.root;
        int index = 1;
        int existChildren = 0;
        for (Character item: addWord.toCharArray()) {
            if (currentNode.containChildren(item)) {
                existChildren++;
            }
            if (!currentNode.containChildren(item)) {
                currentNode.addChildren(item);
                if (addWord.length() == index) {
                    currentNode = currentNode.getChildrenNode(item);
                    currentNode.addEndOfWordNode(position);
                    result = true;
                    break;
                }
            }
            currentNode = currentNode.getChildrenNode(item);
            if (existChildren == addWord.length()) {
                currentNode = currentNode.getChildrenNode(' ');
                currentNode.addPositionInFileToNode(position);
            }
            index++;
        }
        return result;
    }
    /**
     * The method search  word(char sequence in tree).
     * @param searchWord word to search.
     * @return if find return end node, otherwise return null.
     */
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
