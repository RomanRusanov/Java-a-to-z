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
     * Constructor for figure.
     *
     * @param position current cell where figure exist.
     */
    Elephant(Cell position) {
        super(position);
    }
    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException, ImpossibleCreateCellException {
        Cell[] result = new Cell[0];
        boolean upAndRigthChek = false;
        // up and rigth.
        int x = position.getX();
        int y = position.getY();
        do {
            if (x++ <= 8 && y++ <= 8) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x,y);
            } else {
                upAndRigthChek = true;
            }
        } while(!upAndRigthChek);
        // down and rigth.
        int x = position.getX();
        int y = position.getY();
        do {
            if (x++ <= 8 && y-- >= 0) {
                result = copyOf(result, result.length + 1);
                result[result.length - 1] = new Cell(x,y);
            } else {
                upAndRigthChek = true;
            }
        } while(!upAndRigthChek);
        return result;
    }

}
