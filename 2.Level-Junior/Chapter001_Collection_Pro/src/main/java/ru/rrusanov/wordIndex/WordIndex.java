package ru.rrusanov.wordIndex;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2018
 *
 * This class load text file to collection TrieTree, each word(sequence between space char(32)) be loaded.
 * Character value (-1 end of file),(32 space),(10 win symbol new line),(13 symbol carriage return)
 */
public class WordIndex {
    /**
     * The instance Tree collection.
     */
    private TrieTree trieTree = new TrieTree();
    /**
     * The method words from file to tree.
     * @param filename filename
     */
    public void loadFile(String filename) {
        int position = 0;
        int i;
        StringBuilder currentWord = new StringBuilder();
        try (FileInputStream fin = new FileInputStream(filename)) {
            do {
                i = fin.read();
                // -1 end of file, 32 space symbol, 10 new line, 13 carriage return
                if (i != -1 && i != 32 && i != 10 && i != 13) {
                    currentWord.append(Character.toString((char) i));
                }
                if (i == 32 || i == -1) {
                    trieTree.put(currentWord.toString(), position - currentWord.length());
                    currentWord = new StringBuilder();
                }
                position++;
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File" + filename + "not found!");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        }
    }
    /**
     * The method return Set that contain int value position passed searchWord, if word not present then return null.
     * @param searchWord Word to search in tree.
     * @return Set<Integer> where int value is position in file what word, if not exist word return null.
     */
    public Set<Integer> getIndexes4Word(String searchWord) {
        Set<Integer> result = null;
        Node nodeWordRef = this.trieTree.search(searchWord);
        if (nodeWordRef != null) {
            result = nodeWordRef.getPositionInFile();
        }
        return result;
    }
}
