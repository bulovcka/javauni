package prac21.task2;

public class ArrayHolder {
    Object[] array;
    public ArrayHolder(Object[] arr){
        array = arr;
    }
    public Object[] getArray() {
        return array;
    }
    public void setArray(Object[] array) {
        this.array = array;
    }
    public Object getID(int id){
        return array[id];
    }
}
