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
        cell.setFigure(this);
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

    protected MovingInterface longMovement(int destination){
        Cell currentCell = cell.getNeighbours(destination);
        int counter = 0;
        boolean killedFlag = false;
        MovingInterface[] res = new MovingInterface[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = new DefaultMoving(this, destination);
            currentCell = currentCell.getNeighbours(destination);
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            killedFlag = true;
            res[counter] = new KillDecorator(new DefaultMoving(this, destination), currentCell, currentCell.getFigure());
        }
        return new MovingComposite(killedFlag, res);
    }

    protected Coordinates[] longMovementGetCoords(int destination){
        Cell currentCell = cell.getNeighbours(destination);
        int counter = 0;
        Coordinates[] res = new Coordinates[MAX];
        while (currentCell != null && currentCell.getFigure() == null){
            res[counter] = currentCell.getCoordinates();
            currentCell = currentCell.getNeighbours(destination);
            counter++;
        }
        if(currentCell != null && currentCell.getFigure().getIsWhite() != isWhite){
            res[counter]  = currentCell.getCoordinates();
        }
        return res;
    }

    protected MovingInterface arbitraryMove(int x, int y){
        Cell tmpCell = board.getCell(x, y);
        if (tmpCell != null && tmpCell.getFigure() != null && tmpCell.getFigure().getIsWhite() != isWhite) {
            return  new MovingComposite(true, new KillDecorator(new ArbitraryMoving(this, tmpCell.getCoordinates()), tmpCell, tmpCell.getFigure()));
        }
        if (tmpCell != null && tmpCell.getFigure() == null) {
            return new MovingComposite(false, new ArbitraryMoving(this, tmpCell.getCoordinates()));
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
