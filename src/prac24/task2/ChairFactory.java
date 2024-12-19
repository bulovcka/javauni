package prac24.task2;



import prac24.task2.Interfaces.AbstractChairFactory;

public class ChairFactory implements AbstractChairFactory {
    @Override
    public VictorianChair createVictorianChair(int age) {
        return new VictorianChair(age);
    }

    @Override
    public MagicChair createMagiChair() {
        return new MagicChair();
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return null;
    }
}