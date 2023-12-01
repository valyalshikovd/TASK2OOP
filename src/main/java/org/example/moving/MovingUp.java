package org.example.moving;


import org.example.Figure.FigureInterface;
import org.example.moving.MovingInterface;

public class MovingUp extends Moving {


    public MovingUp(FigureInterface figure) {
        super(figure);
    }
    public boolean moving(){
        if(figure.getCell().getUpCell() == null){
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getUpCell());
        figure.getCell().setFigure(figure);
        return true;
    }
    public void reverse(){
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getDownCell());
        figure.getCell().setFigure(figure);
    }
}
