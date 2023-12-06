package org.example.Player;

import org.example.ChessBoard;
import org.example.moving.MovingInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PlayerOnBoard extends Player {
    private List<Consumer<MovingInterface>> observers = new ArrayList<>();

    private ChessBoard board;
    private MovingInterface actualMove;
    private boolean actual;


    public PlayerOnBoard(String name) {
        super(name);
    }

    @Override
    public MovingInterface getStep() throws InterruptedException {
        while(board.getClickedMoving() == null){
            Thread.sleep(3000);
            System.out.println("Ожидание");
        }
        MovingInterface movingInterface = board.getClickedMoving();
        board.setClickedMovingNull();
        return movingInterface;
    }

    public void setBoard(ChessBoard board){
        this.board = board;
    }

    @Override
    public void addInfoFromBoard(MovingInterface movingInterface) {
        this.actualMove = movingInterface;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.accept(actualMove));
    }

}
