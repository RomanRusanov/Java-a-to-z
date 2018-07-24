package ru.rrusanov.wordIndex;

import org.junit.Test;
import ru.rrusanov.tree.Tree;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TrieTreeTest {

    @Test
    public void put() {
        TrieTree trieTree = new TrieTree();
        trieTree.put("hellow", 0);
        trieTree.put("hellboy", 0);
        Node hellow = trieTree.search("hellow");
        Node hellboy = trieTree.search("hellboy");
        System.out.println(trieTree);
    }

    @Test
    public void loadFile() throws IOException {
        WordIndex wordIndex = new WordIndex();
        wordIndex.loadFile("wordsFile.txt");
    }

    @Test
    public void getIndexes4Word() throws IOException {
        Set<Integer> result = new HashSet<>();
        WordIndex wordIndex = new WordIndex();
        wordIndex.loadFile("wordsFile.txt");
        result = wordIndex.getIndexes4Word("world");
    }
}