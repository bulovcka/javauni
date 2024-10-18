package prac6_1;

public class Main {
    public static void main(String args[]){
        MovablePoint point = new MovablePoint(0, 1, 2,3);
        MovableCircle circle = new MovableCircle(2,2,4,5,6);
        MovableRectangle rectangle = new MovableRectangle(1,1,2,2,3,3,3,3);
        System.out.println(point);
        System.out.println(circle);
        System.out.println(rectangle);
        rectangle.moveDown();
        System.out.println(rectangle);
    }
}
