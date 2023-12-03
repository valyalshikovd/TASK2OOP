package org.example.moving;

import org.example.Figure.FigureInterface;
import org.example.Game.Cell;
import org.example.Game.Coordinates;

public class ArbitraryMoving implements MovingInterface{
    protected FigureInterface figure;
    protected Coordinates coordinates;
    protected Cell cellBefore;
    public ArbitraryMoving(FigureInterface figure, Coordinates coordinates) {
        this.figure = figure;
        this.coordinates = coordinates;
        cellBefore = figure.getCell();
    }

    @Override
    public boolean moving() {
        Cell cell = figure.getBoard().getCell(coordinates.getX(), coordinates.getY());
        if(figure.getBoard().getCell(coordinates.getX(), coordinates.getY()) == null){
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(cell);
        cell.setFigure(figure);
        return true;
    }

    @Override
    public void reverse() {
        Cell cell = figure.getBoard().getCell(coordinates.getX(), coordinates.getY());

        cell.setFigure(null);
        cellBefore.setFigure(figure);
        figure.setCell(cellBefore);

    }
}