package ru.rrusanov.wordIndex;

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

    private Integer positionInFile;

    private Character character;

}
