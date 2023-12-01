package org.example.moving;

import org.example.Events.EventInterface;
import org.example.Figure.FigureInterface;

public abstract class Moving implements MovingInterface {
    protected FigureInterface figure;
    public Moving(FigureInterface figure) {
        this.figure = figure;
    }
}
