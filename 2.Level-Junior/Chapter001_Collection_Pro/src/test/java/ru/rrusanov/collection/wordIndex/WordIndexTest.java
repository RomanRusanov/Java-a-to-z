package ru.rrusanov.collection.wordIndex;
import org.junit.Assert;
import org.junit.Test;
import java.util.Set;
/**
 * The class check WordIndex.java class behavior.
 */
public class WordIndexTest {
    /**
     * The instance of a test class.
     */
    private WordIndex wordIndex = new WordIndex();
    /**
     * The test for method loadFile() getIndexes4Word().
     */
    @Test
    public void whenFileLoadedThenGetIndexesReturnPositionOfWordsInFile() {
        this.wordIndex.loadFile("wordsFile.txt");
        Set<Integer> result = wordIndex.getIndexes4Word("world");
        Assert.assertTrue(result.contains(7));
        Assert.assertTrue(result.contains(33));
    }
    /**
     * The test for method loadFile() when word not exist.
     */
    @Test
    public void whenWordNotExistInFileThenReturnNull() {
        this.wordIndex.loadFile("wordsFile.txt");
        Assert.assertNotNull(wordIndex.getIndexes4Word("world"));
        Assert.assertNull(wordIndex.getIndexes4Word("superman"));
    }
    /**
     * The test all logic WordIndex using alternative method from String.indexOf().
     */
    @Test
    public void whenStringIndexOfReturnResultThenWordIndexReturnSameResult() {
        this.wordIndex.loadFile("wordsFile.txt");
        String stringFile = "hellow world how are you doing \n\rworld what you feel now";
        String findString1 = "world";
        int stringPosition = stringFile.indexOf(findString1);
        Assert.assertTrue(wordIndex.getIndexes4Word(findString1).contains(stringPosition));
        String findString2 = "what";
        stringPosition = stringFile.indexOf(findString2);
        Assert.assertTrue(wordIndex.getIndexes4Word(findString2).contains(stringPosition));
    }
}