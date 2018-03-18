/**
 *@author Roman Rusanov
 * @version 0.1
 * @since 4.12.2017
 *
 * Board.java Class contains chess board and all figures.
 * Methods:
 *  Figure lastAddedFigure() Method return last added figure.
 *  Figure getFigureFromCell(Cell cell) throws ImpossibleCreateCellException Method return figure if it is present on the cell.
 *  boolean move(Cell source, Cell dest) throws
 *    ImpossibleMoveException Check correct movement of figure,
 *    OccupiedWayException Check the way of movement not blocked other figure,
 *    FigureNotFoundException Method check what destination cell have figure,
 *    ImpossibleCreateCellException Check correct cell value.
 *  void addNewFigure(Figure figure) Add new figure at board.
 *  Cell[] getOccupiedCells() Contain all occupied cells.
 *
 * Cell.java Class contains cell of chess board.
 * Methods:
 *  int getX() getter for x coordinate.
 *  int getY() getter for y coordinate.
 *  String toString() Overide toString() method.
 *  boolean equals(Object otherObject) Overide eqals() method.
 *  int hashcode() hashcode() method.
 *
 * Elephant.java Describes Elephant figure.
 * Methods:
 *  Cell[] way(Cell dest) throws ImpossibleMoveException, ImpossibleCreateCellException Way that figure can cross on board.
 *  Figure clone(Cell dest) throws ImpossibleCreateCellException Clone one figure to another cell.
 *
 * Figure.java Abstract class describes chess figure.
 * Methods:
 *  long getId() generate unique id for create figure.
 *  abstract Cell[] way(Cell dest) throws ImpossibleMoveException, ImpossibleCreateCellException Way that figure can cross on board.
 *  boolean equals(Object otherObject) Override equals methods.
 *  abstract Figure clone(Cell dest) throws ImpossibleCreateCellException Clone one figure to another cell.
 *
 * FigureNotFoundException.java If source cell not have figure exist.
 * ImpossibleCreateCellException.java Possibly wrong value x,y for create cell.
 * ImpossibleMoveException.java If destination cell busy or on way exist other figure generate exception.
 * OccupiedWayException.java If way of movement of figure cross another figure.
 */
package ru.rrusanov;