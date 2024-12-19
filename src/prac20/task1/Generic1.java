package prac20.task1;

public class Generic1<T , V, K> {
    private T t;
    private V v;
    private K k;

    public Generic1(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public void display() {
        System.out.println("Class of T: " + t.getClass().getName());
        System.out.println("Class of V: " + v.getClass().getName());
        System.out.println("Class of K: " + k.getClass().getName());
    }

    public static void main(String[] args) {
        Generic1<Integer, String, Double> myObject = new Generic1<>(42, "Hello, World!", 3.14);
        myObject.display();
    }
}
