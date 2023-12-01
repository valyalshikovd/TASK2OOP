package org.example.Game;

import org.example.Exeptions.ChessException;

public class CellFactory{
    public CellFactory() {

    }
    public static Cell createSell(int x, int y)  {
            if ((x + y) % 2 == 0) {
                return new Cell(Color.White, new Coordinates(x, y));
            }
            return new Cell(Color.Black, new Coordinates(x, y));

    }
}
