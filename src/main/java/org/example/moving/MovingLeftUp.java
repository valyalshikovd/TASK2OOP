
package org.example.moving;

import org.example.Figure.FigureInterface;

public class MovingLeftUp extends Moving {
    public MovingLeftUp(FigureInterface figure) {
        super(figure);
    }

    @Override
    public boolean moving() {
        if (figure.getCell().getLeftUPCell() == null) {
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getLeftUPCell());
        figure.getCell().setFigure(figure);
        return true;
    }

    @Override
    public void reverse() {
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getRightDownCell());
        figure.getCell().setFigure(figure);
    }
}

