package org.example;
import org.example.Figure.*;
import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard extends JFrame {
    private JPanel chessBoardPanel;
    private Board board;
    private boolean clickedFlag;
    private FigureInterface movedFigure;
    private Coordinates clickedCoords;
    private List<Coordinates> variantsCoords;

    public ChessBoard(Board b) {
        this.board = b;
        this.clickedFlag = false;
        setLayout(new BorderLayout());

        chessBoardPanel = new JPanel(new GridLayout(12, 12));

        add(chessBoardPanel, BorderLayout.CENTER);

        createChessBoard();

        setSize(480, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createChessBoard() {
        Color lightSquareColor = new Color(255, 206, 158);
        Color darkSquareColor = new Color(209, 139, 71);

        for (int row = 0; row < 12; row++) {
            for (int col = 0 ; col < 12; col++) {

                if( (row == 11
                    || row == 0
                    || col == 0
                    || col == 11) &&
                        !((row == 0 && col == 0)
                                ||(row == 11 && col == 0)
                                ||(row == 0 && col == 11)
                                ||(row == 11 && col == 11)
                                )){
                    JPanel square = new JPanel();
                    square.setPreferredSize(new Dimension(40, 40));

                    chessBoardPanel.add(square);
                    continue;
                }

                JPanel square = new JPanel();
                square.setPreferredSize(new Dimension(40, 40));

                if ((row + col) % 2 == 0) {
                    square.setBackground(lightSquareColor);
                } else {
                    square.setBackground(darkSquareColor);
                }

                square.addMouseListener(new ChessBoardClickListener(row - 1, col - 1));
                addChessPiece(square, row, col);
                chessBoardPanel.add(square);
            }
        }
//        addCornerSquare(0, 0);
//        addCornerSquare(0, 11);
//        addCornerSquare(11, 0);
//        addCornerSquare(11, 11);
    }
    private void addCornerSquare(int row, int col) {
        JPanel square = new JPanel();
        square.setPreferredSize(new Dimension(40, 40));
        square.setBackground(Color.LIGHT_GRAY);
        chessBoardPanel.add(square, row * 12 + col);
    }
    private void addChessPiece(JPanel square, int row, int col) {
        FigureInterface f = board.getCell(row  - 1 , col - 1).getFigure();
        if(f instanceof Pawn){
            addPiece(square, "P",f.getIsWhite());
        }
        if(f instanceof Rook){
            addPiece(square, "R", f.getIsWhite());
        }
        if(f instanceof Queen){
            addPiece(square, "Q", f.getIsWhite());
        }
        if(f instanceof Bishop){
            addPiece(square, "B", f.getIsWhite());                  //	U+1F451
        }
        if(f instanceof King){

            addPiece(square, "king", f.getIsWhite());
        }
    }

    private void addPiece(JPanel square, String piece, boolean isWhite) {
        JLabel label = new JLabel(piece, SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        if(isWhite){
            label.setForeground(Color.WHITE);
        }else{
            label.setForeground(Color.BLACK);
        }
        square.add(label);
    }

    private class ChessBoardClickListener implements java.awt.event.MouseListener {
        private int row;
        private int col;

        public ChessBoardClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            if(clickedFlag  && board.getCell(row, col) != null){
                boolean flag = false;
                for(Coordinates coord : variantsCoords){
                    System.out.println(coord.getX());
                    System.out.println(coord.getY());
                    System.out.println(row+1);
                    System.out.println(col+1);
                    System.out.println("-----------------");
                    if(coord.getX() == row && coord.getY() == col){
                        System.out.println("rerere");
                        flag = true;
                    }
                }
                if(!flag){
                    return;
                }
                Cell cell = board.getCell(clickedCoords.getX(), clickedCoords.getY());
                Cell cell2 = board.getCell(row, col);
                cell2.setFigure(movedFigure);
                movedFigure.setCell(cell2);
                cell.setFigure(null);
                clickedFlag = false;
                resetChessBoard();
                variantsCoords = null;
            }else{
                movedFigure = board.getCell(row, col).getFigure();
                clickedCoords = movedFigure.getCell().getCoordinates();
                Coordinates[][] coordinates = movedFigure.getMovingVariantsOnCoords();
                clickedFlag = true;
                variantsCoords = new ArrayList<>();
                for (Coordinates[] coords : coordinates){
                    for (Coordinates coord : coords){
                        if(coord == null){
                            continue;
                        }
                        variantsCoords.add(coord);
                        highlightSquare(coord.getX(), coord.getY());
                    }
                }
            }
            System.out.println("Clicked on square: (" + row + ", " + col + ")");
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
        }
    }
    private void highlightSquare(int row, int col) {
        ((JPanel) chessBoardPanel.getComponent(( row + 1 ) * 12 + (col + 1))).setBackground(Color.GREEN);
    }
    private void resetChessBoard() {
        chessBoardPanel.removeAll();
        createChessBoard();
        chessBoardPanel.revalidate();
        chessBoardPanel.repaint();
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.buildBoard();
        b.getCell(3,6).setFigure(new Pawn(b.getCell(3,6), true, b));

        b.getCell(8,6).setFigure(new Rook(b.getCell(8,6), false, b));

        b.getCell(8,7).setFigure(new Queen(b.getCell(8,7), false, b));

        b.getCell(1,1).setFigure(new Bishop(b.getCell(1,1), true, b));

        b.getCell(2,2).setFigure(new King(b.getCell(2,2), false, b));
        SwingUtilities.invokeLater(() -> new ChessBoard(b));
    }
}
