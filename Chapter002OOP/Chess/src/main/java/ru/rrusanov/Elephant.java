package ru.rrusanov;
/**
 * Describes Elephant figure.
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.11.17
 */
public class Elephant implements FigureType {
    /**
     * Name of type.
     * @return String name of figure.
     */
    public String info() {
        return "Elephant";
    }
    /**
     * Check possible move from position.
     * @param position cell where figure stay at now.
     * @return Cell[] where figure can go.
     */
    public Cell[] possibleMovesFromCell(Cell position) {
        int x = position.getX();
        int y = position.getY();
        Cell[] result;
        int index = 1;
        boolean chekComplete = false;
        do {
            if (x + 1 <= 8 && y + 1 <=8 ) {

            } else {
                chekComplete = true;
            }
        } while (!chekComplete);
    }
}
