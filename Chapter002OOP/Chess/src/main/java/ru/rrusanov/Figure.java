package ru.rrusanov;
/** Class describes chess figure.
 * @author Roman Rusanov
 * @since 13.11.2017
 * @version 0.1
 */
public abstract class Figure {
    /**
     * Constructor for figure.
     */
    Figure(Cell position, ChessType chessType) {
        this.position = position;
        this.chessType = chessType;
    }
    /**
     * Position figure on board chess.
     */
    private final Cell position;
    /**
     * ChessType figure of chess.
     */
    private final ChessType chessType;
    /**
     * Way that figure can cross on board.
     * @param source from what cell you want move figure.
     * @param dest where you wan to move figure.
     * @return Cell[] all cells that figure need go to the destination cell.
     */
    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;
}
