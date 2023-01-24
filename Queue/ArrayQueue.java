package Queue;

import java.util.Arrays;

public class ArrayQueue<E> {
    private Object[] arr;
    private int front=-1;
    private int back=-1;
    private int count = 0;
    ArrayQueue(int N){
        arr = new Object[N];
    }
    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
    public void enqueue(E val){
        if(isEmpty())front++;
        if(isFull()){
            throw new IllegalStateException();
        }
        arr[(++back) % arr.length]=val;
        count++;
    }
    @SuppressWarnings("unchecked")
    public E dequeue(){
        if(isEmpty())throw new IllegalStateException();
        E val = (E)arr[front%arr.length];
        if(count == 1){
            front=back=-1;
        } else {
            front++;
        }
        count--;
        return val;
    }
    @SuppressWarnings("unchecked")
    public E peek(){
        if(isEmpty())return null;
        return (E)arr[front];
    }
    public void show(){
        if(isEmpty())return;
        int x=0;
        int back2 = back;
        for(int i=front;i<=back2;i++){
            if(x<count && i== arr.length){
                i = i % arr.length;
                back2 = back2 % arr.length;
            }
            System.out.print(arr[i]+" ");
            x++;
        }
        System.out.println();
    }
    public boolean isFull(){
        return count == arr.length;
    }
    public boolean isEmpty(){
        return count==0;
    }
    
}
