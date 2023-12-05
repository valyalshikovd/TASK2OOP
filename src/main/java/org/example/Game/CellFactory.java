package org.example.Game;
public class CellFactory{
    public static Cell createSell(int x, int y)  {
        return new Cell(new Coordinates(x, y));
    }
}
