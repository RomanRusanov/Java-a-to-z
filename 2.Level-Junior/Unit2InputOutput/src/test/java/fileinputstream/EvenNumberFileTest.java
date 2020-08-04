package fileinputstream;
import org.junit.Assert;
import org.junit.Test;

/**
 * The test check behavior EvenNumberFile.java.
 */
public class EvenNumberFileTest {
    /**
     * When pass even number then return true, otherwise false.
     */
    @Test
    public void whenNumberEvenThenReturnTrue() {
        Assert.assertTrue(EvenNumberFile.isEvenNumber(2));
        Assert.assertFalse(EvenNumberFile.isEvenNumber(3));
    }
}