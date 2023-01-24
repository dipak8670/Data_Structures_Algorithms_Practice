package Queue;

import java.util.Stack;

public class StackQueue<E>{
    private Stack<E> stack1;
    private Stack<E> stack2;
    StackQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(E val){
        stack1.push(val);
    }
    public E dequeue(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    
}
