package org.example;
import org.example.Figure.*;
import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.Game.GameState;
import org.example.Player.Bot;
import org.example.Player.PlayerInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
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
    private GameState gs;

    public ChessBoard(PlayerInterface playerInterface1, PlayerInterface playerInterface2) {
        this.gs = new GameState(playerInterface1, playerInterface2);
        this.board = gs.getBoard();
        this.clickedFlag = false;
        setLayout(new BorderLayout());

        chessBoardPanel = new JPanel(new GridLayout(12, 12));

        add(chessBoardPanel, BorderLayout.CENTER);
        createChessBoard();
        chessBoardPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(gs.isGameWasFinished()){
                    return;
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gs.stepBack();
                    resetChessBoard();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    gs.setStep();
                    resetChessBoard();
                }
            }
        });


        setSize(480, 480);
        setLocationRelativeTo(null);

        chessBoardPanel.setFocusable(true);
        chessBoardPanel.requestFocusInWindow();
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
    }
    private void addCornerSquare(int row, int col) {
        JPanel square = new JPanel();
        square.setPreferredSize(new Dimension(40, 40));
        square.setBackground(Color.LIGHT_GRAY);
        chessBoardPanel.add(square, row * 12 + col);
    }
    private void addChessPiece(JPanel square, int row, int col) {
        FigureInterface f = board.getCell(row  - 1 , col - 1).getFigure();
        if(f != null) {
            addPiece(square, f.getName(), f.getIsWhite());
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
            if(gs.isGameWasFinished()){
                return;
            }
            if(clickedFlag  && board.getCell(row, col) != null){
                boolean flag = false;
                for(Coordinates coord : variantsCoords){
                    if(coord.getX() == row && coord.getY() == col){
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
                    if(coords == null){
                        continue;
                    }
                    for (Coordinates coord : coords){
                        if(coord == null){
                            continue;
                        }
                        variantsCoords.add(coord);
                        highlightSquare(coord.getX(), coord.getY());
                    }
                }
            }
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
        SwingUtilities.invokeLater(() -> new ChessBoard(new Bot("Димас"), new Bot("ЫВАЫВПЫВПВЫПЫВРПАВОПВКОЕА")));
    }
}
