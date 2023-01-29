package BinaryTree;

public class TreeImp {
    public static void main(String args[]){
        Tree t=new Tree();
        t.add(10);
        t.add(7);
        t.add(15);
        t.add(4);
        System.out.println(t.find(12));
        t.preorder();
        t.inOrder();
        t.postOrder();
        System.out.println(t.findHeight());
        System.out.println(t.min());
        System.out.println();
    }
    
}
