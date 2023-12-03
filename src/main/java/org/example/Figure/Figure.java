package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Color;
import org.example.Game.Coordinates;
import org.example.moving.*;

public abstract class Figure implements FigureInterface{
    protected Cell cell;
    protected final boolean isWhite;
    private static final int MAX = 12;
    protected final Board board;


    public Figure(Cell cell, boolean isWhite, Board board) {
        this.cell = cell;
        this.isWhite = isWhite;
        this.board = board;
        if(isWhite){
            board.addToWhiteFigures(this);
        }else{
            board.addToBlackFigures(this);
        }
    }

    @Override
    public boolean getIsWhite() {
        return isWhite;
    }

    @Override
    public Cell getCell() {
        return cell;
    }

    @Override
    public void setCell(Cell cell) {
        this.cell = cell;
    }
    @Override
    public Board getBoard(){
        return board;
    }

    protected MovingInterface[] longMovementUp(){
        Cell currentCell = cell.getUpCell();
        int counter = 0;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new MovingUp(this);
            currentCell = currentCell.getUpCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = new Kill(this, currentCell.getFigure(), currentCell);
            res[counter + 1] = new MovingUp(this);
        }
        return res;
    }

    protected MovingInterface[] longMovementDown(){
        Cell currentCell = cell.getDownCell();
        int counter = 0;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new MovingDown(this);
            currentCell = currentCell.getDownCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = new Kill(this, currentCell.getFigure(), currentCell);
            res[counter + 1] = new MovingDown(this);
        }
        return res;
    }

    protected MovingInterface[] longMovementRight(){
        Cell currentCell = cell.getRightCell();
        int counter = 0;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new MovingRight(this);
            currentCell = currentCell.getRightCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = new Kill( this,currentCell.getFigure(), currentCell);
            res[counter + 1] = new MovingRight(this);
        }
        return res;
    }

    protected MovingInterface[] longMovementLeft(){
        Cell currentCell = cell.getLeftCell();
        int counter = 0;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new MovingLeft(this);
            currentCell = currentCell.getLeftCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = new Kill( this,currentCell.getFigure(), currentCell);
            res[counter + 1] = new MovingLeft(this);
        }
        return res;
    }
    protected Coordinates[] longMovementLeftUpGetCoords(){
        Cell currentCell = cell.getLeftUPCell();
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getLeftUPCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }
    protected Coordinates[] longMovementLeftDownGetCoords(){
        Cell currentCell = cell.getLeftDownCell();
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getLeftDownCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }

    protected Coordinates[] longMovementRightUpGetCoords(){
        Cell currentCell = cell.getRightUPCell();
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getRightUPCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }
    protected Coordinates[] longMovementRightDownGetCoords(){
        Cell currentCell = cell.getRightDownCell();
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getRightDownCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }


    protected MovingInterface[] longMovementLeftUp(){
        Cell currentCell = cell.getLeftUPCell();
        int counter = 0;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new MovingLeftUp(this);
            currentCell = currentCell.getLeftUPCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = new Kill( this,currentCell.getFigure(), currentCell);
            res[counter + 1] = new MovingLeftUp(this);
        }
        return res;
    }
    protected MovingInterface[] longMovementLeftDown(){
        Cell currentCell = cell.getLeftDownCell();
        int counter = 0;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new MovingLeftDown(this);
            currentCell = currentCell.getLeftDownCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = new Kill( this,currentCell.getFigure(), currentCell);
            res[counter + 1] = new MovingLeftDown(this);
        }
        return res;
    }

    protected MovingInterface[] longMovementRightUp(){
        Cell currentCell = cell.getRightUPCell();
        int counter = 0;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new MovingRightUp(this);
            currentCell = currentCell.getRightUPCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = new Kill( this,currentCell.getFigure(), currentCell);
            res[counter + 1] = new MovingRightUp(this);
        }
        return res;
    }
    protected MovingInterface[] longMovementRightDown(){
        Cell currentCell = cell.getRightDownCell();
        int counter = 0;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new MovingRightDown(this);
            currentCell = currentCell.getRightDownCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = new Kill( this,currentCell.getFigure(), currentCell);
            res[counter + 1] = new MovingRightDown(this);
        }
        return res;
    }
    protected Coordinates[] longMovementUpGetCoords(){
        Cell currentCell = cell.getUpCell();
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getUpCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }

    protected Coordinates[] longMovementDownGetCoords(){
        Cell currentCell = cell.getDownCell();
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getDownCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }

    protected Coordinates[] longMovementRightGetCoords(){
        Cell currentCell = cell.getRightCell();
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getRightCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }

    protected Coordinates[] longMovementLeftGetCoords(){
        Cell currentCell = cell.getLeftCell();
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getLeftCell();
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }

    protected MovingInterface[] arbitraryMove(int x, int y){
        Cell tmpCell = board.getCell(x, y);
        if (tmpCell != null && tmpCell.getFigure() != null && tmpCell.getFigure().getIsWhite() != isWhite) {
            return  new MovingInterface[]{new Kill(this, tmpCell.getFigure(), tmpCell) , new ArbitraryMoving(this, tmpCell.getCoordinates())};
        }
        if (tmpCell != null && tmpCell.getFigure() == null) {
            return new MovingInterface[]{new ArbitraryMoving(this, tmpCell.getCoordinates())};
        }
        return null;
    }

    protected Coordinates[] arbitraryMoveGetCoords(int x, int y){
        Cell tmpCell = board.getCell(x, y);
        if (tmpCell != null && tmpCell.getFigure() != null && tmpCell.getFigure().getIsWhite() != isWhite) {
            return   new Coordinates[]{new Coordinates(tmpCell.getCoordinates().getX(), tmpCell.getCoordinates().getY())};
        }
        if (tmpCell != null && tmpCell.getFigure() == null) {
            return   new Coordinates[]{new Coordinates(tmpCell.getCoordinates().getX(), tmpCell.getCoordinates().getY())};
        }
        return null;
    }


}
