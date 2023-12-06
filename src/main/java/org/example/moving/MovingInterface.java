package org.example.moving;

import org.example.Figure.FigureInterface;
import org.example.Game.Coordinates;

public interface MovingInterface {
    public boolean moving();
    public void reverse();
    public FigureInterface getFigure();
    public int getSize();
    public boolean isKilled();
    public Coordinates[] getCoordinates();
}
