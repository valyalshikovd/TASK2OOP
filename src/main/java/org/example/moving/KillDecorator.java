package org.example.moving;

import org.example.Figure.FigureInterface;
import org.example.Game.Cell;

public class KillDecorator implements MovingInterface{

    private final MovingInterface moving;
    private final Cell cell;
    private final FigureInterface killedFigure;
    private int size = 0;

    public KillDecorator(MovingInterface moving, Cell cell, FigureInterface killedFigure) {
        this.moving = moving;
        this.cell = cell;
        this.killedFigure = killedFigure;
    }

    @Override
    public boolean moving() {
        try {
            if(killedFigure.getIsWhite()){
                killedFigure.getBoard().removeToWhiteFigures(killedFigure);
            }else{
                killedFigure.getBoard().removeToBlackFigures(killedFigure);
            }
            killedFigure.getCell().setFigure(null);
            killedFigure.setCell(null);
            size++;
            return moving.moving();
        }catch (Exception e){
            System.out.println(cell + "  - ячейка");
            System.out.println(cell.getFigure() + "  - фигура в ячейке");
            System.out.println(killedFigure + "  - убитая фигура");
            System.out.println(getFigure() + "  - фигура вызвавшая метод");
            return false;
        }
    }

    @Override
    public void reverse() {
        moving.reverse();
        if(killedFigure.getIsWhite()){
            killedFigure.getBoard().addToWhiteFigures(killedFigure);
        }else{
            killedFigure.getBoard().addToBlackFigures(killedFigure);
        }
        cell.setFigure(killedFigure);
        killedFigure.setCell(cell);
    }

    @Override
    public FigureInterface getFigure() {
        return moving.getFigure();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isKilled() {
        return true;
    }
}
