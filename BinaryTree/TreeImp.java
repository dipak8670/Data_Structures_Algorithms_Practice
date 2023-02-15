package BinaryTree;

public class TreeImp {
    public static void main(String args[]){
        Tree t=new Tree();
        t.add(10);
        t.add(7);
        t.add(15);
        t.add(4);
        t.add(21);
        t.add(1);
        t.add(32);
        Tree t2=new Tree();
        t2.add(10);
        t2.add(7);
        t2.add(15);
        t2.add(4);
        System.out.println(t.find(12));
        t.preorder();
        t.inOrder();
        t.postOrder();
        t.BFS();
        t.deleteNode(10);
        t.BFS();
        System.out.println(t.findHeight());
        System.out.println(t.min());
        System.out.println(t.minValue());
        System.out.println(t.isEqual(t2));
        System.out.println(t.isValidBinarySearchTree());
        t2.swap();
        System.out.println(t2.isValidBinarySearchTree());
        System.out.println(t.printNodeAtK(2));
        System.out.println();
    }
    
}
