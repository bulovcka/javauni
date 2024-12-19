package prac17.task2;


public class Node{
    private Double data;
    private Node prev = null;
    private  Node next = null;
    public Node(Double dataValue){
        this.data = dataValue;
    }

    public Node(Double dataValue, Node next){
        this.next = next;
        this.data = dataValue;
    }

    public Double getData(){
        return data;
    }

    public void setData(Double dataValue){
        this.data = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int compareTo(Node other){
        return data.compareTo(other.data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
