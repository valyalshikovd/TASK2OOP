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
    public MovingInterface[][] getMovingVariants(){
        MovingInterface[][] res = new MovingInterface[3][2];


        if(isWhite){
            if(cell.getUpCell().getFigure() == null){
                res[0][0] = new MovingUp(this);
            }
            if(cell.getLeftUPCell()!= null
                    && cell.getLeftUPCell().getFigure()!= null
                    &&  cell.getLeftUPCell().getFigure().getIsWhite() != isWhite){
                res[1][0] = new Kill(this,cell.getLeftUPCell().getFigure(),cell.getLeftUPCell());
                res[1][1] = new MovingLeftUp(this);
            }

            if(cell.getRightUPCell()!= null && cell.getRightUPCell().getFigure()!= null && cell.getRightUPCell().getFigure().getIsWhite() != isWhite){
                res[2][0] = new Kill(this,cell.getRightUPCell().getFigure(),cell.getRightUPCell());
                res[2][1] = new MovingRightUp(this);
            }
        }else{
            if(cell.getDownCell().getFigure() == null){
                res[0][0] = new MovingDown(this);
            }
            if(cell.getLeftDownCell()!= null && cell.getLeftDownCell().getFigure()!= null &&cell.getLeftDownCell().getFigure().getIsWhite() != isWhite){
                res[1][0] = new Kill(this,cell.getLeftDownCell().getFigure(),cell.getLeftDownCell());
                res[1][1] = new MovingLeftDown(this);
            }

            if(cell.getRightDownCell()!= null && cell.getRightDownCell().getFigure()!= null && cell.getRightDownCell().getFigure().getIsWhite() != isWhite){
                res[2][0] = new Kill(this,cell.getRightDownCell().getFigure(),cell.getRightDownCell());
                res[2][1] = new MovingRightDown(this);
            }
        }


        return res;
    }
    @Override
    public Coordinates[][] getMovingVariantsOnCoords(){
        Coordinates[][] res = new Coordinates[3][2];

        if(isWhite){

            if(cell.getUpCell().getFigure() == null){
                res[0] = new Coordinates[]{cell.getUpCell().getCoordinates()};
            }
            System.out.println(cell.getLeftCell());
            if(cell.getLeftUPCell()!= null
                    && cell.getLeftUPCell().getFigure()!= null
                    && cell.getLeftUPCell().getFigure().getIsWhite() != isWhite){
                res[1] = new Coordinates[]{cell.getLeftUPCell().getCoordinates()};
            }

            if(cell.getRightUPCell()!= null
                    && cell.getRightUPCell().getFigure()!= null
                    && cell.getRightUPCell().getFigure().getIsWhite() != isWhite){
                res[2] = new Coordinates[]{ cell.getRightUPCell().getCoordinates()};
            }
        }else{
            if(cell.getDownCell().getFigure() == null){
                res[0] = new Coordinates[]{cell.getDownCell().getCoordinates()};
            }
            if(cell.getLeftDownCell()!= null
                    && cell.getLeftDownCell().getFigure()!= null
                    && cell.getLeftDownCell().getFigure().getIsWhite() != isWhite){
                res[1] = new Coordinates[]{cell.getLeftDownCell().getCoordinates()};
            }

            if(cell.getRightDownCell()!= null
                    && cell.getRightDownCell().getFigure()!= null
                    && cell.getRightDownCell().getFigure().getIsWhite() != isWhite){
                res[2] = new Coordinates[]{cell.getRightDownCell().getCoordinates()};
            }
        }

        return res;
    }





}
