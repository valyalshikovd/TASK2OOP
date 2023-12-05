package org.example.Game;

import org.example.Player.PlayerInterface;
import org.example.moving.MovingInterface;

import java.util.Stack;

public class GameState {
    private PlayerInterface whitePlayerInterface1;
    private PlayerInterface blackPlayerInterface2;
    private Board board;

    private boolean gameWasFinished = false;

    private Stack<MovingInterface> movingInterfaceStack;
    private PlayerInterface movedPlayer;

    public GameState(PlayerInterface playerInterface1, PlayerInterface playerInterface2) {
        this.whitePlayerInterface1 = playerInterface1;
        this.blackPlayerInterface2 = playerInterface2;
        this.board = new Board();
        this.whitePlayerInterface1.setFigures(board.getWhiteFiguresNonSafety());
        this.blackPlayerInterface2.setFigures(board.getBlackFiguresNonSafety());
        movingInterfaceStack = new Stack<>();
        movedPlayer = playerInterface1;
    }

    public void setStep() {
        if(gameWasFinished){
            return;
        }
        MovingInterface move = movedPlayer.getStep();
        movingInterfaceStack.add(move);
        move.moving();
        if (whitePlayerInterface1 == movedPlayer) {
            movedPlayer = blackPlayerInterface2;
        } else {
            movedPlayer = whitePlayerInterface1;
        }
        if(!board.getWhiteFiguresNonSafety().contains(board.getWhiteKing())){
            System.out.println("Победил игрок " + whitePlayerInterface1.getName());
            gameWasFinished = true;
        }
        if(!board.getBlackFiguresNonSafety().contains(board.getBlackKing())){
            System.out.println("Победил игрок " + blackPlayerInterface2.getName());
            gameWasFinished = true;
        }
    }

    public void stepBack() {
        movingInterfaceStack.pop().reverse();
    }

    public Board getBoard() {
        return board;
    }

    public PlayerInterface getMovedPlayer() {
        return movedPlayer;
    }

    public boolean isGameWasFinished() {
        return gameWasFinished;
    }
}
