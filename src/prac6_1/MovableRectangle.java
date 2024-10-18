package prac6_1;

public class MovableRectangle implements Movable{
    public MovablePoint topLeft;
    public MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed1, int ySpeed1, int xSpeed2, int ySpeed2) {
        topLeft = new MovablePoint(x1, y1, xSpeed1, ySpeed1);
        bottomRight = new MovablePoint(x2, y2, xSpeed2, ySpeed2);
    }

    public MovablePoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(MovablePoint topLeft) {
        this.topLeft = topLeft;
    }

    public MovablePoint getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(MovablePoint bottomRight) {
        this.bottomRight = bottomRight;
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }

    @Override
    public void moveUp() {
        if (hasSameSpeed(topLeft, bottomRight)){
            topLeft.moveUp();
            bottomRight.moveUp();
        }else{
            System.out.println("Error");
        }
    }

    @Override
    public void moveDown() {
        if (hasSameSpeed(topLeft, bottomRight)){
            topLeft.moveDown();
            bottomRight.moveDown();
        }else{
            System.out.println("Error");
        }
    }

    @Override
    public void moveLeft() {
        if (hasSameSpeed(topLeft, bottomRight)){
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }else{
            System.out.println("Error");
        }
    }

    @Override
    public void moveRight() {
        if (hasSameSpeed(topLeft, bottomRight)){
            topLeft.moveRight();
            bottomRight.moveRight();
        }
    }

    public boolean hasSameSpeed(MovablePoint topLeft,MovablePoint bottomRight){
        return topLeft.xSpeed == bottomRight.xSpeed &&
                topLeft.ySpeed == bottomRight.ySpeed;
    }
}
