package ru.rrusanov.wordIndex;

import org.junit.Test;
import ru.rrusanov.tree.Tree;

import static org.junit.Assert.*;

public class TrieTreeTest {

    @Test
    public void put() {
        TrieTree trieTree = new TrieTree();
        trieTree.put("hellow");
        trieTree.put("hellboy");
        System.out.println(trieTree);
    }
}