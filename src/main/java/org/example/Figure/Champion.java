package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.MovingInterface;

public class Champion extends Figure{
    public Champion(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {

        Coordinates[][] res =  new Coordinates[12][];

        if(cell.getUpCell()!= null && cell.getUpCell().getFigure() != null && cell.getUpCell().getFigure().getIsWhite() != isWhite ){
            res[0] = new Coordinates[]{cell.getUpCell().getCoordinates()};

        }
        if(cell.getUpCell()!= null&& cell.getUpCell().getFigure() == null){
            res[0] = new Coordinates[]{cell.getUpCell().getCoordinates()};
        }

        if(cell.getDownCell()!= null && cell.getDownCell().getFigure() != null && cell.getDownCell().getFigure().getIsWhite() != isWhite ){
            res[1] =  new Coordinates[]{cell.getDownCell().getCoordinates()};

        }
        if(cell.getDownCell()!= null&& cell.getDownCell().getFigure() == null){
            res[1] = new Coordinates[]{cell.getDownCell().getCoordinates()};
        }

        if(cell.getLeftCell()!= null && cell.getLeftCell().getFigure() != null && cell.getLeftCell().getFigure().getIsWhite() != isWhite ){
            res[2] =  new Coordinates[]{cell.getLeftCell().getCoordinates()};

        }
        if(cell.getLeftCell()!= null&& cell.getLeftCell().getFigure() == null){
            res[2] =  new Coordinates[]{cell.getLeftCell().getCoordinates()};
        }



        if(cell.getRightCell()!= null && cell.getRightCell().getFigure() != null && cell.getRightCell().getFigure().getIsWhite() != isWhite ){
            res[3] =  new Coordinates[]{cell.getRightCell().getCoordinates()};

        }
        if(cell.getRightCell()!= null&& cell.getRightCell().getFigure() == null){
            res[3] =  new Coordinates[]{cell.getRightCell().getCoordinates()};
        }

        res[4] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() + 2);
        res[5] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() - 2);
        res[6] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() - 2);
        res[7] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() + 2);

        res[8] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY());
        res[9] = arbitraryMoveGetCoords(cell.getCoordinates().getX() -2 , cell.getCoordinates().getY() );
        res[10] = arbitraryMoveGetCoords(cell.getCoordinates().getX() , cell.getCoordinates().getY() - 2);
        res[11] = arbitraryMoveGetCoords(cell.getCoordinates().getX() , cell.getCoordinates().getY() + 2);
        return res;
    }

    @Override
    public MovingInterface[][] getMovingVariants() {
        return new MovingInterface[0][];
    }
}
