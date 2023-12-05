package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Color;
import org.example.Game.Coordinates;
import org.example.moving.*;

import java.util.function.Function;

public class Pawn extends Figure {


    public Pawn(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[] getMovingVariants(){
        MovingInterface[] res = new MovingInterface[3];

        if(cell == null){
            System.out.println(this);
            return null;
        }


        if(!isWhite){
            if(cell.getNeighbours(Cell.UP).getFigure() == null){
                res[0] = new DefaultMoving(this, Cell.UP);
            }
            if(cell.getNeighbours(Cell.LEFT_UP)!= null
                    && cell.getNeighbours(Cell.LEFT_UP).getFigure()!= null
                    &&  cell.getNeighbours(Cell.LEFT_UP).getFigure().getIsWhite() != isWhite){
                res[1] = new KillDecorator(new DefaultMoving(this, Cell.LEFT_UP),cell.getNeighbours(Cell.LEFT_UP), cell.getNeighbours(Cell.LEFT_UP).getFigure());
            }

            if(cell.getNeighbours(Cell.RIGHT_UP)!= null && cell.getNeighbours(Cell.RIGHT_UP).getFigure()!= null && cell.getNeighbours(Cell.RIGHT_UP).getFigure().getIsWhite() != isWhite){
                res[2] = new KillDecorator(new DefaultMoving(this, Cell.RIGHT_UP),cell.getNeighbours(Cell.RIGHT_UP), cell.getNeighbours(Cell.RIGHT_UP).getFigure());
            }
        }else{
            if(cell.getNeighbours(Cell.DOWN).getFigure() == null){
                res[0] = new DefaultMoving(this, Cell.DOWN);
            }
            if(cell.getNeighbours(Cell.LEFT_DOWN)!= null && cell.getNeighbours(Cell.LEFT_DOWN).getFigure()!= null &&cell.getNeighbours(Cell.LEFT_DOWN).getFigure().getIsWhite() != isWhite){
                res[1] = new KillDecorator(new DefaultMoving(this, Cell.LEFT_DOWN),cell.getNeighbours(Cell.LEFT_DOWN), cell.getNeighbours(Cell.LEFT_DOWN).getFigure());
            }

            if(cell.getNeighbours(Cell.RIGHT_DOWN)!= null && cell.getNeighbours(Cell.RIGHT_DOWN).getFigure()!= null && cell.getNeighbours(Cell.RIGHT_DOWN).getFigure().getIsWhite() != isWhite){
                res[2] = new KillDecorator(new DefaultMoving(this, Cell.RIGHT_DOWN),cell.getNeighbours(Cell.RIGHT_DOWN), cell.getNeighbours(Cell.RIGHT_DOWN).getFigure());
            }
        }
        return res;
    }

    @Override
    public String getName() {
        return "P";
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords(){
        Coordinates[][] res = new Coordinates[3][2];

        if(!isWhite){

            if(cell.getNeighbours(Cell.UP).getFigure() == null){
                res[0] = new Coordinates[]{cell.getNeighbours(Cell.UP).getCoordinates()};
            }
            if(cell.getNeighbours(Cell.LEFT_UP)!= null
                    && cell.getNeighbours(Cell.LEFT_UP).getFigure()!= null
                    && cell.getNeighbours(Cell.LEFT_UP).getFigure().getIsWhite() != isWhite){
                res[1] = new Coordinates[]{cell.getNeighbours(Cell.LEFT_UP).getCoordinates()};
            }

            if(cell.getNeighbours(Cell.RIGHT_UP)!= null
                    && cell.getNeighbours(Cell.RIGHT_UP).getFigure()!= null
                    && cell.getNeighbours(Cell.RIGHT_UP).getFigure().getIsWhite() != isWhite){
                res[2] = new Coordinates[]{ cell.getNeighbours(Cell.RIGHT_UP).getCoordinates()};
            }
        }else{
            if(cell.getNeighbours(Cell.DOWN).getFigure() == null){
                res[0] = new Coordinates[]{cell.getNeighbours(Cell.DOWN).getCoordinates()};
            }
            if(cell.getNeighbours(Cell.LEFT_DOWN)!= null
                    && cell.getNeighbours(Cell.LEFT_DOWN).getFigure()!= null
                    && cell.getNeighbours(Cell.LEFT_DOWN).getFigure().getIsWhite() != isWhite){
                res[1] = new Coordinates[]{cell.getNeighbours(Cell.LEFT_DOWN).getCoordinates()};
            }

            if(cell.getNeighbours(Cell.RIGHT_DOWN)!= null
                    && cell.getNeighbours(Cell.RIGHT_DOWN).getFigure()!= null
                    && cell.getNeighbours(Cell.RIGHT_DOWN).getFigure().getIsWhite() != isWhite){
                res[2] = new Coordinates[]{cell.getNeighbours(Cell.RIGHT_DOWN).getCoordinates()};
            }
        }

        return res;
    }





}
