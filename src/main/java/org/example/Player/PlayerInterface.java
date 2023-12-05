package org.example.Player;

import org.example.Figure.Figure;
import org.example.Figure.FigureInterface;
import org.example.moving.MovingInterface;

import java.util.ArrayList;
import java.util.List;

public interface PlayerInterface {

    public MovingInterface getStep();
    public void setName(String name);
    public String getName();
    public void setFigures(List<FigureInterface> figures);
    public void addInfoFromBoard(MovingInterface movingInterface);
    public boolean isPlayer();
}
