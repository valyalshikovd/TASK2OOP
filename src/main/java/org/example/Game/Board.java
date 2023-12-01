package org.example.Game;

import org.example.Figure.Figure;
import org.example.Figure.FigureInterface;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SIZE = 10;

    private Cell rootCell;
    private List<FigureInterface> whiteFigures = new ArrayList<>();
    private List<FigureInterface> blackFigures = new ArrayList<>();

    public Board() {
    }

    public void buildBoard(){
        creatingCellsOnBoard();
        creatingWitchCells();
    }
    public Cell getCell(int x, int y){
        return new CellFinder(rootCell, x, y).getFindedCell();
    }
    private boolean checkValideCoords(int i){
        return i < SIZE && i >= 0;
    }

    private void creatingCellsOnBoard(){
        Cell[] current =  createBoardRow(0);
        rootCell = current[0];
        for(int i = 1; i < SIZE; i++){
            Cell[] res = createBoardRow(i);

            for (int j = 0; j < SIZE; j++ ) {
                if(checkValideCoords(j+1)){
                    current[j].setRightDownCell(res[j+1]);
                    res[j+1].setLeftUPCell(current[j]);
                }
                current[j].setDownCell(res[j]);
                res[j].setUpCell(current[j]);
                if(checkValideCoords(j-1)){
                    current[j].setLeftDownCell(res[j-1]);
                    res[j-1].setRightUPCell(current[j]);
                }
            }
            current = res;
        }
    }
    private void creatingWitchCells(){

        getCell(0,0).setLeftUPCell(CellFactory.createSell(-1, -1));
        getCell(0,0).getLeftUPCell().setRightDownCell(getCell(0,0));

        getCell(9,0).setLeftDownCell(CellFactory.createSell(10, -1));
        getCell(9,0).getLeftDownCell().setRightUPCell(getCell(9,0));

        getCell(0,9).setRightUPCell(CellFactory.createSell(-1, 10));
        getCell(0,9).getRightUPCell().setLeftDownCell(getCell(0,9));


        getCell(9,9).setRightDownCell(CellFactory.createSell(10, 10));
        getCell(9,9).getRightDownCell().setLeftUPCell(getCell(9,9));

    }

    private Cell[] createBoardRow(int x){
        Cell[] resList = new Cell[SIZE];
        for(int i = 0; i < SIZE; i++){
            resList[i] = CellFactory.createSell(x, i);
            if(i - 1 >= 0){
                resList[i - 1].setRightCell(resList[i]);
                resList[i].setLeftCell(resList[i - 1]);
            }
        }
        return resList;
    }

    public Cell getRootCell() {
        return rootCell;
    }

    public List<FigureInterface> getWhiteFigures() {
        return new ArrayList<>(whiteFigures);
    }

    public List<FigureInterface> getBlackFigures() {
        return new ArrayList<>(blackFigures);
    }
    public void addToWhiteFigures(FigureInterface figure){
        whiteFigures.add(figure);
    }
    public void addToBlackFigures(FigureInterface figure){
        blackFigures.add(figure);
    }

    public void removeToWhiteFigures(FigureInterface figure){
        whiteFigures.remove(figure);
    }
    public void removeToBlackFigures(FigureInterface figure){
        blackFigures.remove(figure);
    }
}
