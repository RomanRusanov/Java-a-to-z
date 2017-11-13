package ru.rrusanov;
/**
 * Describes Elephant figure.
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.11.17
 */
public class Elephant implements ChessType {
    /**
     * Name of type.
     * @return String name of figure.
     */
    public String info() {
        return "Elephant";
    }
    /**
     * Check.
     * @param position cell where figure stay at now.
     * @return Cell[] where figure can go.
     */
    public Cell[] checkMove(Cell position) {
        int x = position.getX();
        int y = position.getY();
        Cell[] result;
        boolean chekComplete = false;
        do {

        } while (!chekComplete);
    }
}
