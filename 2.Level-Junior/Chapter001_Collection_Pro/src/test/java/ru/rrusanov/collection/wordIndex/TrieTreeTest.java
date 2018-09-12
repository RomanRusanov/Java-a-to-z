package ru.rrusanov.collection.wordIndex;
import org.junit.Assert;
import org.junit.Test;
import java.util.NoSuchElementException;
/**
 * The class check TrieTree.java class behavior.
 */
public class TrieTreeTest {
    /**
     * The field contain instance of test class.
     */
    private TrieTree trieTree = new TrieTree();
    /**
     * The test check method put(), search().
     * And check method search() trows exception when word not present in tree.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenPutInTreeThenSearchReturnThatNode() {
        this.trieTree.put("hellow", 0);
        this.trieTree.put("hellboy", 0);
        Node hellow = this.trieTree.search("hellow");
        Node hellboy = this.trieTree.search("hellboy");
        Node hell = this.trieTree.search("hell");
        Assert.assertTrue(hellboy.isWord());
        Assert.assertTrue(hellow.isWord());
        Assert.assertTrue(hell.isWord()); //Throw NoSuchElementException
    }
}