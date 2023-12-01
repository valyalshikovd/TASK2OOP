package org.example.moving;

import org.example.Figure.FigureInterface;

public class MovingRightUp extends Moving {
    public MovingRightUp(FigureInterface figure) {
        super(figure);
    }

    @Override
    public boolean moving() {
        if (figure.getCell().getRightUPCell() == null) {
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getRightUPCell());
        figure.getCell().setFigure(figure);
        return true;
    }

    @Override
    public void reverse() {
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getLeftDownCell());
        figure.getCell().setFigure(figure);
    }
}

