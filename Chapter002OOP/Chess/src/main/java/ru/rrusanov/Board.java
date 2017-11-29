package ru.rrusanov;
import static java.util.Arrays.copyOf;
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
     * Default constructor.
     */
    public Board() {
        figures = new Figure[] {};
    }
    /**
     * Method return last added figure.
     * @return figure.
     */
    public Figure lastAddedFigure() {
        Figure result = figures[figures.length - 1];
        return result;
    }
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
     * Add new figure at board.
     * @param figure type of figure.
     */
    public void addNewFigure(Figure figure) throws ImpossibleCreateCellException {
        Cell[] occupiedCells = this.getOccupiedCells();
        for (Cell occupied:occupiedCells) {
            if (figure.position.equals(occupied)) {
                throw new OccupiedWayException("This cell occupied another figure!");
            } else {
                figures = copyOf(figures, figures.length + 1);
                figures[figures.length - 1] = figure;
//                if (figures.length == 0 ) {
//                    figures[0] = figure;
//                } else {
//                    figures[figures.length - 1] = figure;
//                }
            }
        }
    }
    /**
     * Contain all occupied cells.
     * @return Cell[] Occupied cells.
     */
    public Cell[] getOccupiedCells() throws FigureNotFoundException {
        int length = figures.length;
        if (length >= 1) {
            Cell[] result = new Cell[length];
            int index = 0;
            for (Figure f : figures) {
                result[index] = f.position;
                index++;
            }
            return result;
        } else {
            return new Cell[] {};
            //throw new FigureNotFoundException("No figure on board!");
        }
    }
}
