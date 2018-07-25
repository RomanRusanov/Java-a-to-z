package ru.rrusanov.wordIndex;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2018
 *
 * This class describes the Node properties an behavior.
 */
public class Node {
    /**
     * The field true, when char sequence form a word. Otherwise false then char intermediate.
     */
    private boolean isWord;
    /**
     * The field Set contain all children of that node.
     */
    private Set<Node> children;
    /**
     * The field Set contain all occurrence in file.
     */
    private Set<Integer> positionInFile;
    /**
     * The filed character contain char of that node.
     */
    private Character character;
    /**
     * The default constructor.
     * @param character Character that node must store.
     */
    public Node(Character character) {
        this.isWord = false;
        this.children = new HashSet<>();
        this.positionInFile = new HashSet<>();
        this.character = character;
    }
    /**
     * The method add last node after word(char sequence) this node contain counter of occurrence this word in file,
     * and filed isWord set to true.
     * @param position Position word in file int value.
     */
    public void addEndOfWordNode(int position) {
        Node nodeToAdd = new Node(' ');
        nodeToAdd.isWord = true;
        nodeToAdd.positionInFile.add(position);
        this.children.add(nodeToAdd);
    }
    /**
     * The method add children in Node Set.
     * @param character Character that Node be store.
     */
    public void addChildren(Character character) {
        this.children.add(new Node(character));
    }
    /**
     * The method return children node that contain passed character.
     * @param character Character to find in children set.
     * @return Finded node.
     * @throws NoSuchElementException if node not find throw exception.
     */
    public Node getChildrenNode(Character character) throws NoSuchElementException {
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
    /**
     * The method return set with position of word occurrence in file.
     * @return reference to field set that contain int value.
     */
    public Set<Integer> getPositionInFile() {
        return this.positionInFile;
    }
    /**
     * The method add position in file to set.
     * @param position int value to add.
     */
    public void addPositionInFileToNode(int position) {
        this.positionInFile.add(position);
    }
    /**
     * The method return field value.
     * @return true if node refer to end word node with position in file value, other wise false.
     */
    public boolean isWord() {
        return isWord;
    }
    /**
     * The method check node contain children in set with passed char value.
     * @param character Character to find.
     * @return If contain return true, otherwise false.
     */
    public boolean containChildren(Character character) {
        boolean result = false;
        for (Node item: this.children) {
            if (item.character.equals(character)) {
                result = true;
            }
        }
        return result;
    }
    /**
     * The method override equals method from Object class.
     * @param object node to compare.
     * @return if all fields instance equals, when return true, otherwise return false.
     */
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
    /**
     * The method override hashCode method from Object class.
     * @return int value hashcode.
     */
    @Override
    public int hashCode() {
        return 31 * ((this.isWord ? 1 : 0)
                + this.children.hashCode()
                + this.positionInFile.hashCode()
                + this.character.hashCode());
    }
}
