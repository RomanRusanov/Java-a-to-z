package ru.rrusanov;
/** Class contains chess board and all figures.
 * @author Roman Rusanov
 * @since 14.11.2017
 * @version 0.1
 */
public class Board {
    /**
     * Contain all figures.
     */
    private Figure[] figures;
    /**
     * Method check what destination cell have figure, if no throw exception (FigureNotFoundException).
     * Check correct movement of figure(ImpossibleMoveException).
     * Check the way of movement not blocked other figure, else(OccupiedWayException).
     * @param source from what cell you want move figure.
     * @param dest where you wan to move figure.
     * @return boolean Movement possible.
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
        return false;
    }
    /**
     * Contain all occupied cells.
     * @param figures Contains all figures on boards.
     * @return Cell[] Occupied cells.
     */
    public Cell[] getOccupiedCells(Figure[] figures) {
        Cell[] result = new Cell[figures.length];
        int index = 0;
        for (Figure f:figures) {
            result[index] = f.position;
            index++;
        }
        return result;
    }
}
