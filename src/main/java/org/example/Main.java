package org.example;

import org.example.moving.MovingUp;
import org.example.Figure.Pawn;
import org.example.Game.Board;
import org.example.Game.Color;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        b.buildBoard();
        b.getCell(3,6).setFigure(new Pawn(b.getCell(3,6), true, b));
        System.out.println(b.getCell(3,6));
        new MovingUp(b.getCell(3,6).getFigure()).moving();
        System.out.println(b.getCell(3,6));
        System.out.println(b.getCell(2,6));
    }
}