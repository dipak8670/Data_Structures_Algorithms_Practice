package Heap;

import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int size=0;
    public Heap(int n){
        this.heap=new int[n];
    } 
    public void insert(int n){
        if(isFull())throw new IllegalStateException();
        heap[size++]=n;
        bubbleUp();
    }
    public boolean isFull(){
        return size==heap.length;
    }
    private void bubbleUp(){
        int currentIndex=size-1;
        while(currentIndex>0 && heap[currentIndex]>heap[findParentIndex(currentIndex)]){
            swap(currentIndex,findParentIndex(currentIndex));
            currentIndex=findParentIndex(currentIndex);
        }
    }
    private void swap(int currentIndex, int parentIndex) {
        int temp=heap[currentIndex];
        heap[currentIndex]=heap[parentIndex];
        heap[parentIndex]=temp;
    }
    private int findParentIndex(int currentIndex2) {
        return (currentIndex2-1)/2;
    }
    public void print(){
        System.out.println(Arrays.toString(heap));
    }
    // public int remove(){
        
    // }
    
}
