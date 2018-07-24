package ru.rrusanov.wordIndex;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2018
 *
 *
 */
public class WordIndex {

    private TrieTree trieTree = new TrieTree();

    public void loadFile(String filename) throws IOException {
        int position = 0;
        int i;
        String currentWord = "";
        try (FileInputStream fin = new FileInputStream(filename)) {
            do {
                i = fin.read();
                // -1 end of file, 32 space symbol
                if (i != -1 && i != 32) {
                    currentWord += Character.toString((char) i);
                }
                if (i == 32 || i == -1) {
                    trieTree.put(currentWord, position - currentWord.length());
                    currentWord = "";
                }
                position++;
            } while (i != -1);
        } catch (FileNotFoundException e ) {
            System.out.println("File" + filename + "not found!");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        }
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        Set<Integer> result = new HashSet<>();
        Node nodeWordRef = this.trieTree.search(searchWord);
        if (nodeWordRef != null) {
            result = nodeWordRef.getPositionInFile();
        }
        return result;
    }
}
