package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueImp {
    public static void main(String args[]){
        // Queue<Integer> q1=new ArrayDeque<>();
        // System.out.println(q1.peek());
        Queue<Integer> q = new LinkedList();
        q.add(10);
        q.add(30);
        q.add(0);
        q.add(1);
        System.out.println(q);
        reverseFirstKElements(q, 3);
        System.out.println(q);

        // ArrayQueue<Integer> q= new ArrayQueue<>(3);
        // System.out.println(q.peek());
        // System.out.println(q.isEmpty());
        // q.enqueue(10);
        // System.out.println(q.peek());
        // q.enqueue(20);
        // q.enqueue(30);
        // System.out.println(q.isFull());
        // q.dequeue();
        // System.out.println(q.isFull());
        // q.enqueue(40);
        // q.show();
        // System.out.println(q.peek());
        // q.dequeue();
        // q.dequeue();
        // q.show();
        // System.out.println(q.isFull());
        // System.out.println();


    }
    public static void reverse(Queue<Integer> q){
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.offer(stack.pop());
        }
    }
    public static void reverseFirstKElements(Queue<Integer>q, int K){
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<K && !q.isEmpty()){
            stack.push(q.poll());
            i++;
        }
        Queue<Integer> queue = new LinkedList<>();
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        while(!q.isEmpty()){
            queue.add(q.poll());
        }
        q.addAll(queue);
    }
}
