package Heap;

public class HeapImp {
    public static void main(String[] args) {
        Heap heap=new Heap(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(6);
        heap.insert(15);
        heap.print();
    }
    
}
