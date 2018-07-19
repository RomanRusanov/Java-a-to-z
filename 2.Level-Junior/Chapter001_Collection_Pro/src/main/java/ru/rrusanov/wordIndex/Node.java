package ru.rrusanov.wordIndex;

import java.util.HashSet;
import java.util.NoSuchElementException;
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

    private Set<Integer> positionInFile;

    private Character character;

    public Node(Character character) {
        this.isWord = false;
        this.children = new HashSet<>();
        this.positionInFile = new HashSet<>();
        this.character = character;
    }

    public void addEndOfWordNode() {
        Node nodeToAdd = new Node(' ');
        nodeToAdd.isWord = true;
        this.children.add(nodeToAdd);
    }

    public void addChildren(Character character) {
        this.children.add(new Node(character));
    }

    public Node getChildrenNode(Character character) throws NoSuchElementException{
        Node result = new Node('0');
        if (!this.containChildren(character)) {
            throw new NoSuchElementException("Not presented element in children Set!");
        }
        for (Node item: this.children) {
            if (item.character.equals(character)) {
                result = item;
            }
        }
        return result;
    }

    public boolean isWord() {
        return isWord;
    }

    public void removeChildren(Node node) {
        this.children.remove(node);
    }

    public boolean containChildren(Character character) {
        boolean result = false;
        for (Node item: this.children) {
            if (item.character.equals(character)) {
                result = true;
            }
        }
        return result;
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
        return 31 * ((this.isWord ? 1 : 0)
                + this.children.hashCode()
                + this.positionInFile.hashCode()
                + this.character.hashCode());
    }

}
