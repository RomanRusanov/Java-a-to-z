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
    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException, ImpossibleCreateCellException {
        Cell[] result = new Cell[0];
        boolean oneWayCheck = false;
        boolean destinationFinded = false;
        // up and rigth.
        int x = position.getX();
        int y = position.getY();
        while(!oneWayCheck && !destinationFinded) {
            x++;
            y++;
            if (x <= 8 && y <= 8) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x,y);
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
        while(!oneWayCheck && !destinationFinded) {
            x++;
            y--;
            if (x <= 8 && y >= 1) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x,y);
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
        while(!oneWayCheck && !destinationFinded) {
            x--;
            y--;
            if (x >= 1 && y >= 1) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x,y);
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
        while(!oneWayCheck && !destinationFinded) {
            x--;
            y++;
            if (x >= 1 && y <= 8) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x,y);
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

    @Override
    Figure clone(Cell dest) throws ImpossibleCreateCellException {
        return new Elephant(dest, this.id);
    }
}
