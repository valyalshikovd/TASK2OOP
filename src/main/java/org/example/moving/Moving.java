package org.example.moving;


import org.example.Figure.FigureInterface;

public abstract class Moving implements MovingInterface {



    protected FigureInterface figure;
    public Moving(FigureInterface figure) {
        this.figure = figure;
    }


    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public FigureInterface getFigure() {
        return figure;
    }
}
