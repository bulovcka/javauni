package prac23.task1;


public abstract class AbstractQueue<E> implements Queue<E> {
    protected int size = 0;

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}