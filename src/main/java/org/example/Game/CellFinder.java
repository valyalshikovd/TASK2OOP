package org.example.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CellFinder {

    private List<Cell> listCells = new ArrayList<>();
    private Cell findedCell;

    public CellFinder(Cell cellFromWhichSearch, int x, int y) {
        findedCell = findNullProtected(cellFromWhichSearch, x, y);
    }

    public Cell findNullProtected(Cell cellFromWhichSearch, int x, int y) {

        if (cellFromWhichSearch == null) {
            return null;
        }
        if(listCells.contains(cellFromWhichSearch)){
            return null;
        }
        listCells.add(cellFromWhichSearch);

        if (cellFromWhichSearch.getCoordinates().getX() == x && cellFromWhichSearch.getCoordinates().getY() == y) {
            return cellFromWhichSearch;
        }
        Cell res = findNullProtected(cellFromWhichSearch.getUpCell(), x, y);
        if (res != null) {return res;}
        res = findNullProtected(cellFromWhichSearch.getRightUPCell(), x, y);
        if (res != null) {return res;}
        res = findNullProtected(cellFromWhichSearch.getRightCell(), x, y);
        if (res != null) {return res;}
        res = findNullProtected(cellFromWhichSearch.getRightDownCell(), x, y);
        if (res != null) {return res;}
        res = findNullProtected(cellFromWhichSearch.getDownCell(), x, y);
        if (res != null) {return res;}
        res = findNullProtected(cellFromWhichSearch.getLeftDownCell(), x, y);
        if (res != null) {return res;}
        res = findNullProtected(cellFromWhichSearch.getLeftCell(), x, y);
        if (res != null) {return res;}
        res = findNullProtected(cellFromWhichSearch.getLeftUPCell(), x, y);
        if (res != null) {return res;}
        return null;
    }

    public Cell getFindedCell() {
        return findedCell;
    }
}
