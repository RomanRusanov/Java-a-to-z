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
     * Method return figure if it is present on the cell.
     * @param cell chosen.
     * @return figure.
     */
    public Figure getFigureFromCell(Cell cell) throws ImpossibleCreateCellException {
        Figure result = new Elephant(new Cell(1,1));
        boolean finded = false;
        for (Figure figure:figures) {
            if (figure.position.equals(cell)) {
                result = figure;
                finded = true;
            }
        }
        if (finded) {
            return result;
        } else {
            throw new FigureNotFoundException("No Figure in this cell!");
        }
    }
    /**
     * Method check what destination cell have figure, if no throw exception (FigureNotFoundException).
     * Check correct movement of figure(ImpossibleMoveException).
     * Check the way of movement not blocked other figure, else(OccupiedWayException).
     * @param source from what cell you want move figure.
     * @param dest where you wan to move figure.
     * @return boolean Movement possible.
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException, ImpossibleCreateCellException {
        // Check source and destination cell
        boolean result = false;
        Cell[] occupiedCells = this.getOccupiedCells();
        for (Cell occupied:occupiedCells) {
            if (!source.equals(occupied)) {
                throw new FigureNotFoundException("There is now figure in source cell!");
            } else if (dest.equals(occupied)) {
                throw new OccupiedWayException("There is exist figure in destination cell!");
            }
        }
        // Check move is correct
        Figure figureToMove = getFigureFromCell(source);
        Cell[] wayToMove = figureToMove.way(dest);
        boolean pathOccupied = false;
        for (Cell occupied:occupiedCells) {
            for (Cell way:wayToMove){
                if (way.equals(occupied)) {
                    pathOccupied = true;
                    throw new OccupiedWayException("The path of the figure is occupied by another figure!");
                }
            }
        }
        if (!wayToMove[wayToMove.length - 1].equals(dest)) throw new ImpossibleMoveException("Destination cell not correct for this figure!");
        // Clone figure
        if (!pathOccupied) {
            for (int i = 0; i < figures.length; i++) {
                if (figures[i].equals(figureToMove)) {
                    figures[i] = figureToMove.clone(dest);
                    result = true;
                }
            }
        }
        return result;
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
            }
        }
        if (figures.length == 0 ) {
            this.figures = new Figure[] {figure};
        } else {
            this.figures = copyOf(figures, figures.length + 1);
            figures[figures.length - 1] = figure;
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
            // No figure on board
            return new Cell[] {};
        }
    }
}
