package org.example.moving;

import org.example.Figure.FigureInterface;

public class MovingDown extends Moving {
    public MovingDown(FigureInterface figure) {
        super(figure);
    }
    @Override
    public boolean moving(){
        if(figure.getCell().getDownCell() == null){
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getDownCell());
        figure.getCell().setFigure(figure);
        return true;
    }
    public void reverse(){
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getUpCell());
        figure.getCell().setFigure(figure);
    }
}
