package ru.rrusanov.wordIndex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2018
 *
 *
 */
public class Node {

    private boolean isWord;

    private Set<Node> children;

    private Integer positionInFile;

    private Character character;

    public Node() {
        this.isWord = false;
        this.children = new HashSet<>();
        this.positionInFile = 0;
        this.character = '0';
    }

    public void addChildren(Node node) {
        this.children.add(node);
    }

    public void removeChildren(Node node) {
        this.children.remove(node);
    }

    public boolean containChildren(Node node) {
        return this.children.contains(node);
    }

    public Set<Node> getAllChildren() {
        return this.children;
    }

    public char getCharacter() {
        return this.character;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Node nodeObj = (Node) object;
        return this.children.equals(nodeObj.children)
                && this.character == nodeObj.character
                && this.isWord == nodeObj.isWord
                && this.positionInFile.equals(nodeObj.positionInFile);
    }

    @Override
    public int hashCode() {
        return 31 * (this.isWord ? 1 : this.children.hashCode() + this.positionInFile + this.character.hashCode());
    }

}
