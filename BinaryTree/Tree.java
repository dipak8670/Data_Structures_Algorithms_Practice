package BinaryTree;

public class Tree {
    private class Node{
        private int value;
        private Node left;
        private Node right;
        Node(int val){
            this.value=val;
        }
    }
    public Node root;
    public void add(int val){
        Node n=new Node(val);
        if(root==null){
            root=n;
            return;
        }
        Node p=root;
        while(p!=null){
            if(val>p.value){
                if(p.right == null){
                    p.right=n;
                    break;
                }
                p=p.right;
            } else {
                if(p.left==null){
                    p.left=n;
                    break;
                }
                p=p.left;
            }
        }
        p=new Node(val);
    }
    public boolean find(int val){
        Node p=root;
        while(p!=null){
            if(val==p.value)return true;
            else if(val>p.value){
                p=p.right;
            }else{
                p=p.left;
            }
        }
        return false;
    }
    public void preorder(){
        preorder(root);
        System.out.println();
    }
    private void preorder(Node node){
        if(node==null)return ;
        System.out.print(node.value +" ");
        preorder(node.left);
        preorder(node.right);
    }
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node node){
        if(node==null)return;
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node node){
        if(node==null)return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }
    public int findHeight(){
        return findHeight(root);
    }
    private int findHeight(Node node){
        if(node==null)return -1;
        return 1+ Math.max(findHeight(node.left), findHeight(node.right));
    }
    public int min(){
        return min(root);
    }
    private int min(Node node){
        if(node==null)return Integer.MAX_VALUE;
        if(isLeafNode(node))return node.value;
        int left=min(node.left);
        int right=min(node.right);
        return Math.min(root.value, Math.min(left,right));
    }
    private boolean isLeafNode(Node node) {
        return node.left==null && node.right==null;
    }
}
