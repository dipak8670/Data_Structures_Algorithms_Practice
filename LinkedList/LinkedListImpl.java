package LinkedList;

import java.util.Arrays;

public class LinkedListImpl {
    public static void main(String args[]){
        LinkedListNode list = new LinkedListNode();
        //list.addLast(10);
    //   list.deleteFirst();
    //   list.deleteLast();
      System.out.println(list.getSize());
      System.out.println(Arrays.toString(list.toArray()));
        list.addFirst(12);
        // list.deleteFirst();
        // list.deleteLast();
        list.addFirst(14);
        list.addLast(30);
       // list.addLast(20);
        System.out.println(Arrays.toString(list.toArray()));
        list.viewList();
        System.out.println(list.contains(10));
        System.out.println(list.indexOf(30));
        //  list.deleteFirst();
        //  list.deleteLast();
        list.viewList();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getSize());
        list.reverse();
        list.viewList();
        System.out.println(list.getKthFronLast(0));
        list.showMiddle();
    }
    
}
