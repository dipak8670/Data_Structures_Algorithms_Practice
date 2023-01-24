package LinkedList;

import java.util.NoSuchElementException;

public class LinkedListNode {
    private Node first;
    private Node last;
    private int size;
    public void addFirst(int n){
        Node node=new Node(n);
        size++;
        if(isEmpty()){
            first = node;
            last = node;
            return;
        }
        node.next=first;
        first=node;
    }
    public void addLast(int n){
        Node node = new Node(n);
        size++;
        if(isEmpty()){
            first=node;
            last=first;
            return;
        }
       last.next=node;
       last=last.next;
    }
    public void deleteFirst(){
        if(size>0)size--;
        if(first == last){
            first=null;
            last=null;
            return;
        }
        Node node = first.next;
        first.next = null;
        first = node;
    }
    public void deleteLast(){
        if(size>0)size--;
        if(first == last){
            first = null;
            last=null;
            return;
        }
        Node head = first;
        while(head.next.next!=null){
            head = head.next;
        }
        head.next=null;
        last=head;
    }
    public boolean contains(int n){
        Node head = first;
        while(head.next!=null){
            if(head.val==n)return true;
            head=head.next;
        }
        return false;
    }
    public int indexOf(int n){
        Node head = first;
        int i=0;
        while(head!=null){
            if(head.val == n)return i;
            head = head.next;
            i++;
        }
        throw new NoSuchElementException();
    }
    public void viewList(){
        Node head = first;
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public boolean isEmpty(){
        if(first == null)return true;
        return false;
    }
    public int getSize(){
        return this.size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        int i=0;
        Node head =first;
        while(head!=null){
            array[i]=head.val;
            head=head.next;
            i++;
        }
        return array;
    }
    public void reverse(){
        if(first == last)return;
        Node head = first;
        Node curr = first.next;
        while(curr != null){
            Node next = curr.next;
            curr.next=head;
            head = curr;
            curr = next;
        }
        last=first;
        last.next=null;
        first = head;
    }
    public int getKthFronLast(int k){
        if(isEmpty())throw new IllegalStateException();
        Node a=first;
        Node b=first;
        for(int i=0;i<k-1;i++){
            b=b.next;
            if(b == null)throw new NoSuchElementException();
        }
        while(b!=last){
            b=b.next;
            a=a.next;
        }
        return a.val;
    }

    public void showMiddle(){
        Node a = first;
        Node b= first;
        while(a.next != null && a.next.next != null){
            a= a.next.next;
            b=b.next;
        }
        System.out.print(b.val + " ");
        if(a!=last){
            System.out.println(b.next.val);
        }
    }
}
