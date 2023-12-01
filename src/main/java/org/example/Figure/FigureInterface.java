package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.MovingInterface;

public interface FigureInterface {
    public Cell getCell();
    public void setCell(Cell cell);
    public Coordinates[][] getMovingVariantsOnCoords();
    public MovingInterface[][] getMovingVariants();
    public boolean getIsWhite();
    public Board getBoard();
}
