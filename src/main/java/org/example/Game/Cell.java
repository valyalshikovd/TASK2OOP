package org.example.Game;

import org.example.Figure.FigureInterface;

public class Cell {
    private final Color color;
    private FigureInterface figure = null;
    private final Coordinates coordinates;
    private Cell leftCell = null;
    private Cell leftUPCell = null;
    private Cell leftDownCell = null;
    private Cell RightUPCell = null;
    private Cell RightDownCell = null;
    private Cell RightCell = null;
    private Cell UpCell = null;
    private Cell DownCell = null;

    public Cell(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    public Color getColor() {
        return color;
    }

    public FigureInterface getFigure() {
        return figure;
    }

    public void setFigure(FigureInterface figure) {
        this.figure = figure;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Cell getLeftCell() {
        return leftCell;
    }

    public void setLeftCell(Cell leftCell) {
        this.leftCell = leftCell;
    }

    public Cell getLeftUPCell() {
        return leftUPCell;
    }

    public void setLeftUPCell(Cell leftUPCell) {
        this.leftUPCell = leftUPCell;
    }

    public Cell getLeftDownCell() {
        return leftDownCell;
    }

    public void setLeftDownCell(Cell leftDownCell) {
        this.leftDownCell = leftDownCell;
    }

    public Cell getRightUPCell() {
        return RightUPCell;
    }

    public void setRightUPCell(Cell rightUPCell) {
        RightUPCell = rightUPCell;
    }

    public Cell getRightDownCell() {
        return RightDownCell;
    }

    public void setRightDownCell(Cell rightDownCell) {
        RightDownCell = rightDownCell;
    }

    public Cell getRightCell() {
        return RightCell;
    }

    public void setRightCell(Cell rightCell) {
        RightCell = rightCell;
    }

    public Cell getUpCell() {
        return UpCell;
    }

    public void setUpCell(Cell upCell) {
        UpCell = upCell;
    }

    public Cell getDownCell() {
        return DownCell;
    }

    public void setDownCell(Cell downCell) {
        DownCell = downCell;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "color=" + color +
                ", figure=" + figure +
                ", coordinates=" + coordinates +
                '}';
    }
}
