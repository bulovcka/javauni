package prac21.task1;

public class Generic1<T, V, K> {
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

    public void display(){
        System.out.println("Class of T " + t.getClass().getName());
        System.out.println("Class of V " + v.getClass().getName());
        System.out.println("Class of K " + k.getClass().getName());
    }
    public static void main(String[] args){
        Generic1<String, Integer, Double> g1 = new Generic1<String, Integer, Double>("T", 13, 2.45);
        g1.display();

    }
}
