package Queue;

public class PriorityQueueImp {
    public static void main(String args[]){
        PriorityQueue pq=new PriorityQueue(5);
        pq.add(10);
        pq.add(20);
        pq.add(2);
        pq.add(15);
        pq.add(25);
        pq.show();
        System.out.println(pq.remove());
        System.out.println(pq.size());
        pq.show();
    }
    
}
