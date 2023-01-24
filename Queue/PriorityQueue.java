package Queue;

public class PriorityQueue {
    private int[] arr;
    private int size;
    PriorityQueue(int n){
        this.arr=new int[n];
        this.size=0;
    }
    public void add(int val){
        if(isFull()){
            throw new IllegalStateException();
        }
        int i=findIndexToInsert(val);
        arr[i]=val;
        size++;
    }
    public int findIndexToInsert(int val){
        int i;
        for(i=size-1;i>=0;i--){
            if(arr[i]>val){
                arr[i+1]=arr[i];
            }else{
               break;
            }
        }
        return i+1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==arr.length;
    }
    public void show(){
        if(isEmpty())return;
        for(int i=size-1;i>=0;i--)
        System.out.print(arr[i]+" ");
        System.out.println();
    }
    public int remove(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return arr[--size];
    }
    public int size(){
        return size;
    }
}
