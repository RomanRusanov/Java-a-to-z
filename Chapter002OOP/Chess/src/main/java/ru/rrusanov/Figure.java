package ru.rrusanov;
/** Class describes chess figure.
 * @author Roman Rusanov
 * @since 13.11.2017
 * @version 0.1
 */
public abstract class Figure extends Board {
    /**
     * Constructor for figure.
     */
    Figure(Cell position) {
        this.position = position;
    }
    /**
     * Position figure on board chess.
     */
    final Cell position;
    /**
     * Way that figure can cross on board.
     * @param dest where you wan to move figure.
     * @return Cell[] all cells that figure need go to the destination cell.
     */
    abstract Cell[] way(Cell dest) throws ImpossibleMoveException, ImpossibleCreateCellException;
    /**
     *
     */


}
