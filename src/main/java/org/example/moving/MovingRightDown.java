package org.example.moving;

import org.example.Figure.FigureInterface;

public class MovingRightDown extends Moving {
    public MovingRightDown(FigureInterface figure) {
        super(figure);
    }

    @Override
    public boolean moving() {
        if (figure.getCell().getRightUPCell() == null) {
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getRightDownCell());
        figure.getCell().setFigure(figure);
        return true;
    }

    @Override
    public void reverse() {
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getLeftUPCell());
        figure.getCell().setFigure(figure);
    }
}