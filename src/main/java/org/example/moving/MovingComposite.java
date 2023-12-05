package org.example.moving;

import org.example.Figure.FigureInterface;

import java.util.Arrays;

public class MovingComposite implements MovingInterface{
    private final MovingInterface[] movingInterfaces;
    private final boolean isKilled;

    public MovingComposite(boolean isKilled, MovingInterface... movingInterfaces) {
        this.movingInterfaces = movingInterfaces;
        this.isKilled = isKilled;
    }

    @Override
    public boolean moving() {
        for(MovingInterface move : movingInterfaces){
            if(move != null){
                move.moving();
            }
        }
        return true;
    }

    @Override
    public void reverse() {
        for(MovingInterface move : movingInterfaces){
            if(move != null){
                move.reverse();
            }
        }
    }

    @Override
    public FigureInterface getFigure() {
        return null;
    }

    @Override
    public int getSize() {
        int counter = 0;
        for(MovingInterface m : movingInterfaces){
            if(m != null){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isKilled() {

        return isKilled;
    }

    @Override
    public String toString() {
        return "MovingComposite{" +
                "movingInterfaces=" + Arrays.toString(movingInterfaces) +
                ", isKilled=" + isKilled +
                '}';
    }
}
