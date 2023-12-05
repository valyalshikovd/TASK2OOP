package org.example.moving;

import org.example.Figure.FigureInterface;

public interface MovingInterface {
    public boolean moving();
    public void reverse();
    public FigureInterface getFigure();
    public int getSize();
    public boolean isKilled();
}
