package ru.rrusanov.wordIndex;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
/**
 * The class test Node.java class behavior.
 */
public class NodeTest {
    /**
     * The instance of test class.
     */
    private Node node = new Node('t');
    /**
     * The test check method addEndOfNode().
     */
    @Test
    public void whenEndNodeAddedThenChildrenContainIt() {
        this.node.addEndOfWordNode(0);
        Assert.assertTrue(this.node.getChildrenNode(' ').isWord());
    }
    /**
     * The test check method addChildren().
     */
    @Test
    public void whenNodeAddedThenChildrenContainIt() {
        this.node.addChildren('r');
        Assert.assertTrue(this.node.containChildren('r'));
    }
    /**
     * The test check method getChildrenNode().
     */
    @Test
    public void whenNodeContainChildrenThenReturnThem() {
        this.node.addChildren('t');
        Assert.assertThat(this.node.getChildrenNode('t'), is(new Node('t')));
    }
    /**
     * The test check method addPositionInFileToNode().
     */
    @Test
    public void whenPositionInFileSetThenItStore() {
        this.node.addPositionInFileToNode(5);
        Assert.assertTrue(this.node.getPositionInFile().contains(5));
    }
    /**
     * The test check method equals().
     */
    @Test
    public void when2NodeHaveEqualsStateThenReturn() {
        Node node1 = new Node('t');
        Node node2 = new Node('s');
        Assert.assertEquals(this.node, node1);
        Assert.assertNotEquals(this.node, node2);
    }
    /**
     * The test check method hashCode().
     */
    @Test
    public void whenNodeEqualsStateThenHashEquals() {
        int node1Hash =  new Node('t').hashCode();
        int node1CloneHash =  new Node('t').hashCode();
        int node2Hash = new Node('s').hashCode();
        Assert.assertEquals(node1Hash, node1CloneHash);
        Assert.assertNotEquals(node1Hash, node2Hash);
    }
}