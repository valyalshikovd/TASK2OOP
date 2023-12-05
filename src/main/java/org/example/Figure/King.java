package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.*;

import static org.example.Game.Cell.SIZE;

public class King extends Figure {
    public King(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res = new Coordinates[SIZE][2];
        for(int i = 0 ; i < SIZE; i++){
            if(cell.getNeighbours(i)!= null && cell.getNeighbours(i).getFigure() != null && cell.getNeighbours(i).getFigure().getIsWhite() != isWhite ){
                res[i][0] = cell.getNeighbours(i).getCoordinates();
            }
            if(cell.getNeighbours(i)!= null&& cell.getNeighbours(i).getFigure() == null){
                res[i][0] = cell.getNeighbours(i).getCoordinates();
            }
        }
        return res;
    }

    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[SIZE];
        for(int i = 0; i < SIZE; i ++ ){
            if(cell.getNeighbours(i)!= null && cell.getNeighbours(i).getFigure() != null && cell.getNeighbours(i).getFigure().getIsWhite() != isWhite ){
                res[i] = new KillDecorator(new DefaultMoving(this, i), cell.getNeighbours(i), cell.getNeighbours(i).getFigure());
            }
            if(cell.getNeighbours(i) != null && cell.getNeighbours(i).getFigure() == null){
                res[i] = new DefaultMoving(this, i);
            }
        }
        return res;
    }
    @Override
    public String getName() {
        return "king";
    }
}