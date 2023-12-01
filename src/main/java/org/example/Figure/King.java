package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.*;

public class King extends Figure {
    public King(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res = new Coordinates[8][2];
        if(cell.getUpCell()!= null && cell.getUpCell().getFigure() != null && cell.getUpCell().getFigure().getIsWhite() != isWhite ){
            res[0][0] = cell.getUpCell().getCoordinates();

        }
        if(cell.getUpCell()!= null&& cell.getUpCell().getFigure() == null){
            res[0][0] = cell.getUpCell().getCoordinates();
        }


        if(cell.getLeftUPCell()!= null && cell.getLeftUPCell().getFigure() != null && cell.getLeftUPCell().getFigure().getIsWhite() != isWhite ){
            res[1][0] = cell.getLeftUPCell().getCoordinates();

        }
        if(cell.getLeftUPCell()!= null&& cell.getLeftUPCell().getFigure() == null){
            res[1][0] = cell.getLeftUPCell().getCoordinates();
        }

        if(cell.getLeftCell()!= null && cell.getLeftCell().getFigure() != null && cell.getLeftCell().getFigure().getIsWhite() != isWhite ){
            res[2][0] = cell.getLeftCell().getCoordinates();

        }
        if(cell.getLeftCell()!= null && cell.getLeftCell().getFigure() == null ){
            res[2][0] = cell.getLeftCell().getCoordinates();
        }

        if(cell.getLeftDownCell()!= null && cell.getLeftDownCell().getFigure() != null && cell.getLeftDownCell().getFigure().getIsWhite() != isWhite ){
            res[3][0] = cell.getLeftDownCell().getCoordinates();

        }
        if(cell.getLeftDownCell()!= null && cell.getLeftDownCell().getFigure() == null ){
            res[3][0] = cell.getLeftDownCell().getCoordinates();
        }

        if(cell.getDownCell()!= null && cell.getDownCell().getFigure() != null && cell.getDownCell().getFigure().getIsWhite() != isWhite ){
            res[4][0] = cell.getDownCell().getCoordinates();

        }
        if(cell.getDownCell()!= null && cell.getDownCell().getFigure() == null ){
            res[4][0] = cell.getDownCell().getCoordinates();
        }

        if(cell.getRightDownCell()!= null && cell.getRightDownCell().getFigure() != null && cell.getRightDownCell().getFigure().getIsWhite() != isWhite ){
            res[5][0] = cell.getRightDownCell().getCoordinates();
        }
        if(cell.getRightDownCell()!= null && cell.getRightDownCell().getFigure() == null ){
            res[5][0] = cell.getRightDownCell().getCoordinates();
        }

        if(cell.getRightCell()!= null && cell.getRightCell().getFigure() != null && cell.getRightCell().getFigure().getIsWhite() != isWhite ){
            res[6][0] = cell.getRightCell().getCoordinates();

        }
        if(cell.getRightCell()!= null && cell.getRightCell().getFigure() == null ){
            res[6][0] = cell.getRightCell().getCoordinates();
        }

        if(cell.getRightUPCell()!= null && cell.getRightUPCell().getFigure() != null && cell.getRightUPCell().getFigure().getIsWhite() != isWhite ){
            res[7][0] = cell.getRightUPCell().getCoordinates();
        }
        if(cell.getRightUPCell()!= null && cell.getRightUPCell().getFigure() == null ){
            res[7][0] = cell.getRightUPCell().getCoordinates();
        }

        return res;
    }


    @Override
    public MovingInterface[][] getMovingVariants() {
        MovingInterface[][] res = new MovingInterface[8][2];
        if(cell.getUpCell()!= null && cell.getUpCell().getFigure() != null && cell.getUpCell().getFigure().getIsWhite() != isWhite ){
            res[0][0] = new Kill(this, cell.getFigure(), cell);
            res[0][1] = new MovingUp(this);
            if(cell.getUpCell().getFigure().getIsWhite() == isWhite ){
                res[0] = new MovingInterface[1];
            }
        }
        if(cell.getUpCell()!= null){
            res[0][0] = new MovingUp(this);
        }


        if(cell.getLeftUPCell()!= null && cell.getLeftUPCell().getFigure() != null && cell.getLeftUPCell().getFigure().getIsWhite() != isWhite ){
            res[1][0] = new Kill(this, cell.getFigure(), cell);
            res[1][1] = new MovingLeftUp(this);
            if(cell.getLeftUPCell().getFigure().getIsWhite() == isWhite ){
                res[1] = new MovingInterface[1];
            }
        }
        if(cell.getLeftUPCell()!= null){
            res[1][0] = new MovingLeftUp(this);
        }

        if(cell.getLeftCell()!= null && cell.getLeftCell().getFigure() != null && cell.getLeftCell().getFigure().getIsWhite() != isWhite ){
            res[2][0] = new Kill(this, cell.getFigure(), cell);
            res[2][1] = new MovingLeft(this);
            if(cell.getLeftCell().getFigure().getIsWhite() == isWhite ){
                res[2] = new MovingInterface[1];
            }
        }
        if(cell.getLeftCell()!= null){
            res[2][0] = new MovingLeft(this);
        }

        if(cell.getLeftDownCell()!= null && cell.getLeftDownCell().getFigure() != null && cell.getLeftDownCell().getFigure().getIsWhite() != isWhite ){
            res[3][0] = new Kill(this, cell.getFigure(), cell);
            res[3][1] = new MovingLeftDown(this);
            if(cell.getLeftDownCell().getFigure().getIsWhite() == isWhite ){
                res[3] = new MovingInterface[1];
            }
        }
        if(cell.getLeftDownCell()!= null){
            res[3][0] = new MovingLeftDown(this);
        }

        if(cell.getDownCell()!= null && cell.getDownCell().getFigure() != null && cell.getDownCell().getFigure().getIsWhite() != isWhite ){
            res[4][0] = new Kill(this, cell.getFigure(), cell);
            res[4][1] = new MovingDown(this);
            if(cell.getDownCell().getFigure().getIsWhite() == isWhite ){
                res[4] = new MovingInterface[1];
            }
        }
        if(cell.getDownCell()!= null){
            res[4][0] = new MovingDown(this);
        }

        if(cell.getRightDownCell()!= null && cell.getRightDownCell().getFigure() != null && cell.getRightDownCell().getFigure().getIsWhite() != isWhite ){
            res[5][0] = new Kill(this, cell.getFigure(), cell);
            res[5][1] = new MovingRightDown(this);
            if(cell.getRightDownCell().getFigure().getIsWhite() == isWhite ){
                res[5] = new MovingInterface[1];
            }
        }
        if(cell.getRightDownCell()!= null){
            res[5][0] = new MovingRightDown(this);
        }

        if(cell.getRightCell()!= null && cell.getRightCell().getFigure() != null && cell.getRightCell().getFigure().getIsWhite() != isWhite ){
            res[6][0] = new Kill(this, cell.getFigure(), cell);
            res[6][1] = new MovingRight(this);
            if(cell.getRightCell().getFigure().getIsWhite() == isWhite ){
                res[6] = new MovingInterface[1];
            }
        }
        if(cell.getRightCell()!= null){
            res[6][0] = new MovingRight(this);
        }

        if(cell.getRightUPCell()!= null && cell.getRightUPCell().getFigure() != null && cell.getRightUPCell().getFigure().getIsWhite() != isWhite ){
            res[7][0] = new Kill(this, cell.getFigure(), cell);
            res[7][1] = new MovingRightUp(this);
            if(cell.getRightUPCell().getFigure().getIsWhite() == isWhite ){
                res[7] = new MovingInterface[1];
            }

        }
        if(cell.getRightUPCell()!= null){
            res[7][0] = new MovingRightUp(this);
        }

        return res;
    }
}
