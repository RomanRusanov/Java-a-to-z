package ru.rrusanov;
import static java.util.Arrays.copyOf;
/**
 * Describes Elephant figure.
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.11.17
 */
public class Elephant extends Figure {
    /**
     * Maximum value cells on board.
     */
    private static final int EIGHT = 8;
    /**
     * Minimum value cells on board.
     */
    private static final int ONE = 1;
    /**
     * Constructor for create figure.
     *
     * @param position current cell where figure exist.
     */
    Elephant(Cell position) {
        super(position);
    }
    /**
     * Constructor for clone figure.
     *
     * @param position current cell where figure exist.
     * @param id assign id.
     */
    Elephant(Cell position, long id) {
        super(position, id);
    }
    /**
     * Way that figure can cross on board.
     * @param dest where you wan to move figure.
     * @return Cell[] all cells that figure need go to the destination cell.
     */
    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException, ImpossibleCreateCellException {
        Cell[] result = new Cell[0];
        boolean oneWayCheck = false;
        boolean destinationFinded = false;
        // up and rigth.
        int x = position.getX();
        int y = position.getY();
        while (!oneWayCheck && !destinationFinded) {
            x++;
            y++;
            if (x <= EIGHT && y <= EIGHT) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x, y);
                if (x == dest.getX() && y == dest.getY()) {
                    oneWayCheck = true;
                    destinationFinded = true;
                }
            } else {
                oneWayCheck = true;
            }
        }
        // down and rigth.
        x = position.getX();
        y = position.getY();
        oneWayCheck = false;
        if (!destinationFinded) {
            result = new Cell[0];
        }
        while (!oneWayCheck && !destinationFinded) {
            x++;
            y--;
            if (x <= EIGHT && y >= ONE) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x, y);
                if (x == dest.getX() && y == dest.getY()) {
                    oneWayCheck = true;
                    destinationFinded = true;
                }
            } else {
                oneWayCheck = true;
            }
        }
        // down and left.
        x = position.getX();
        y = position.getY();
        oneWayCheck = false;
        if (!destinationFinded) {
            result = new Cell[0];
        }
        while (!oneWayCheck && !destinationFinded) {
            x--;
            y--;
            if (x >= ONE && y >= ONE) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x, y);
                if (x == dest.getX() && y == dest.getY()) {
                    oneWayCheck = true;
                    destinationFinded = true;
                }
            } else {
                oneWayCheck = true;
            }
        }
        // up and left.
        x = position.getX();
        y = position.getY();
        oneWayCheck = false;
        if (!destinationFinded) {
            result = new Cell[0];
        }
        while (!oneWayCheck && !destinationFinded) {
            x--;
            y++;
            if (x >= ONE && y <= EIGHT) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x, y);
                if (x == dest.getX() && y == dest.getY()) {
                    oneWayCheck = true;
                    destinationFinded = true;
                }
            } else {
                oneWayCheck = true;
            }
        }
        if (destinationFinded) {
            return result;
        } else {
            throw new ImpossibleMoveException("Destination cell not correct for this figure!");
        }
    }
    /**
     * Clone one figure to another cell.
     * @param dest cell for new position.
     */
    @Override
    Figure clone(Cell dest) throws ImpossibleCreateCellException {
        return new Elephant(dest, this.id);
    }
}
