package prac23.task1;

public class ArrayQueue<E> extends AbstractQueue<E>{
    static Object[] items = new Object[10];
    int front = 0;
    int rear = 0;

//    инвариант: size >= 0; 0 <= front <= rear < items.length


    //    предусловие: el != null
//    постусловие size++;
    @Override
    public void enqueue(E el){
        if (rear + 1 > items.length){
            Object[] newArray = new Object[2 * size];
            System.arraycopy(items, front, newArray, 0, size);
            items = newArray;
            front = 0;
            rear = size;
        }
        items[rear] = el;
        rear++;
        size++;
    }

    //    предусловие: !isEmpty();
//    постусловие: front++; size--;
    @Override
    public E dequeue(){
        if(isEmpty()){
            System.out.println("ArrayQueue.dequeue() -> Queue is empty");
            return null;
        }
        Object ans = items[front];
        front++;
        size--;
        return (E) ans;
    }

    //    предусловие: !isEmpty();
//    постусловие: ...
    @Override
    public E element(){
        if(isEmpty()){
            System.out.println("ArrayQueue.element() -> Queue is empty");
            return null;
        }
        return (E) items[front];
    }

    //    предусловие: ...
    //    постусловие: front = rear = size = 0;
    @Override
    public void clear(){
        items = new Object[10];
        front = 0;
        rear = 0;
        size = 0;
    }


    @Override
    public void display(){
        if(isEmpty()){
            System.out.println("ArrayQueue.display() -> Queue is empty");
        } else {
            System.out.print("Items -> ");
            for(int i = front; i < rear; i++){
                System.out.print(items[i].toString() + " ");
            }
            System.out.println();
            System.out.println("Front index -> " + front);
            System.out.println("Size -> " + size);
            System.out.println("Rear index -> " + (rear - 1));
        }
    }
}