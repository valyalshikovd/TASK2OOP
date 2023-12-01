package org.example.moving;

import org.example.Figure.FigureInterface;

public class MovingLeft extends Moving{
    public MovingLeft(FigureInterface figure) {
        super(figure);
    }

    @Override
    public boolean moving() {
        if(figure.getCell().getLeftCell() == null){
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getLeftCell());
        figure.getCell().setFigure(figure);
        return true;
    }

    @Override
    public void reverse() {
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getRightCell());
        figure.getCell().setFigure(figure);
    }
}