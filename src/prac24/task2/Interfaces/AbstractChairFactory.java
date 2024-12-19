package prac24.task2.Interfaces;



import prac24.task2.FunctionalChair;
import prac24.task2.MagicChair;
import prac24.task2.VictorianChair;

public interface AbstractChairFactory {
    VictorianChair createVictorianChair(int age);
    MagicChair createMagiChair();
    FunctionalChair createFunctionalChair();
}
