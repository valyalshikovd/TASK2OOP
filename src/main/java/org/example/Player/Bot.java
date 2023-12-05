package org.example.Player;

import org.example.Figure.FigureInterface;
import org.example.moving.KillDecorator;
import org.example.moving.MovingInterface;

import java.util.Random;

public class Bot  extends Player{
    private static Random random= new Random();
    public Bot(String name) {
        super(name);
    }

    @Override
    public MovingInterface getStep() {
        System.out.println(this.figures.get(figures.size() - 1).getBoard().getBlackFiguresNonSafety().size() + " черные фигуры");
        System.out.println(this.figures.get(figures.size() - 1).getBoard().getWhiteFiguresNonSafety().size() + " белые фигуры");
        System.out.println(figures.size() + " количество фигур игрока ");
        for(FigureInterface figureInterface : figures){
            MovingInterface[] moves= figureInterface.getMovingVariants();
            for(MovingInterface move : moves){
                System.out.println(move);
                if(move == null){
                    continue;
                }
                if(move.isKilled()){
                    System.out.println(move + " выбранное");
                    return move;
                }
            }
        }




        return randomMove();
    }

    @Override
    public void addInfoFromBoard(MovingInterface movingInterface) {
        return;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    private MovingInterface randomMove(){
        FigureInterface figureInterface = figures.get(random.nextInt(figures.size()));
        MovingInterface[] moves  =  figureInterface.getMovingVariants();
        MovingInterface move = moves[random.nextInt(moves.length)];
        if(move == null){
            return randomMove();
        }
        if(move.getSize() != 0){
            System.out.println(move + " выбранное");
            return move;
        }
        return randomMove();
    }
}
