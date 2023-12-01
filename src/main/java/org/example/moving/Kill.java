package org.example.moving;

import org.example.Figure.FigureInterface;
import org.example.Game.Cell;

public class Kill extends Moving{
    private FigureInterface killedFigure;
    private Cell cell;

    public Kill(FigureInterface figure, FigureInterface killedFigure, Cell cell) {
        super(figure);
        this.killedFigure = killedFigure;
        this.cell = cell;
    }

    @Override
    public boolean moving() {
        if(figure.getIsWhite()){
            cell.getFigure().getBoard().removeToWhiteFigures(cell.getFigure());
            cell.setFigure(null);
        }else{
            cell.getFigure().getBoard().removeToBlackFigures(cell.getFigure());
            cell.setFigure(null);
        }
        return true;
    }

    @Override
    public void reverse() {
        if(figure.getIsWhite()){
            killedFigure.getBoard().addToWhiteFigures(killedFigure);
            cell.setFigure(killedFigure);
        }else{
            killedFigure.getBoard().addToBlackFigures(killedFigure);
            cell.setFigure(killedFigure);
        }
    }
}
