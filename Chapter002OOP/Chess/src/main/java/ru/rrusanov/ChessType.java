package ru.rrusanov;
/**
 * Describes type of chess figure.
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.11.17
 */
public interface ChessType {
    /**
     * Name of type.
     * @return String name of figure.
     */
    public String info();
    /**
     * Check.
     * @return Cell[] where figure can go.
     */
    public Cell[] checkMove(Cell position);
}
