package org.example.Player;

import org.example.ChessBoard;
import org.example.moving.MovingInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PlayerOnBoard extends Player {


    private List<Consumer<MovingInterface>> observers = new ArrayList<>();

    private final ChessBoard board;
    private MovingInterface actualMove;

    private boolean actual;


    public PlayerOnBoard(String name, ChessBoard board) {
        super(name);
        this.board = board;
    }

    @Override
    public MovingInterface getStep() {
        MovingInterface movingInterface = null;
        observers.add(new Consumer<MovingInterface>() {
            @Override
            public void accept(MovingInterface movingInterface) {

            }
        });
        //movingInterface =


        return null;
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
