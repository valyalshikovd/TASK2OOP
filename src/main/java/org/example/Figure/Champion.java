package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.*;

import static org.example.Game.Cell.SIZE;

public class Champion extends Figure{
    public Champion(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {

        Coordinates[][] res =  new Coordinates[12][];

        for(int i = 0; i < 8; i += 2){
            if(cell.getNeighbours(i)!= null && cell.getNeighbours(i).getFigure() != null && cell.getNeighbours(i).getFigure().getIsWhite() != isWhite ){
                res[i / 2] = new Coordinates[]{cell.getNeighbours(i).getCoordinates()};

            }
            if(cell.getNeighbours(i)!= null&& cell.getNeighbours(i).getFigure() == null){
                 res[i / 2] = new Coordinates[]{cell.getNeighbours(i).getCoordinates()};
            }
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
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res =  new MovingInterface[12];

        for (int i = 0; i < SIZE; i += 2){
            if(cell.getNeighbours(i)!= null && cell.getNeighbours(i).getFigure() != null && cell.getNeighbours(i).getFigure().getIsWhite() != isWhite ){
                res[i / 2] = new KillDecorator(new DefaultMoving(this, i),cell,cell.getNeighbours(i).getFigure()) ;
            }
            if(cell.getNeighbours(i)!= null&& cell.getNeighbours(i).getFigure() == null){
                res[i / 2] = new DefaultMoving(this, i);
            }
        }

        res[4] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() + 2);
        res[5] = arbitraryMove(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() - 2);
        res[6] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() - 2);
        res[7] = arbitraryMove(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() + 2);
        res[8] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY());
        res[9] = arbitraryMove(cell.getCoordinates().getX() -2 , cell.getCoordinates().getY() );
        res[10] = arbitraryMove(cell.getCoordinates().getX() , cell.getCoordinates().getY() - 2);
        res[11] = arbitraryMove(cell.getCoordinates().getX() , cell.getCoordinates().getY() + 2);

        return res;
    }

    @Override
    public String getName() {
        return "CH";
    }
}
