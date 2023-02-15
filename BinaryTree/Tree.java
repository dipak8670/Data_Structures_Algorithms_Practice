package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public void BFS(){
        BFS(root);
    }
    private void BFS(Node node) {
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node n=q.remove();
            System.out.print(n.value+" ");
            if(n.left !=null)q.add(n.left);
            if(n.right!=null)q.add(n.right);
        }
        System.out.println();
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
    public int minValue(){
        return minValue(root);
    }
    private int minValue(Node node){
        if(node==null)return Integer.MAX_VALUE;
        if(isLeafNode(node))return node.value;
        return minValue(node.left);
    }
    public boolean isEqual(Tree other){
        return isEqual(root,other.root);
    }
    private boolean isEqual(Node node1, Node node2) {
        if(node1==null && node2==null)return true;
        if(node1==null || node2==null)return false;
        return node1.value == node2.value && isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
    }
    public boolean isValidBinarySearchTree(){
        return isValidBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBinarySearchTree(Node node, int minValue, int maxValue) {
        if(node==null)return true;
        if(node.value<minValue || node.value>maxValue)return false;
        return isValidBinarySearchTree(node.left,minValue,node.value-1) && isValidBinarySearchTree(node.right,node.value+1,maxValue);
    }
    public void swap(){
        Node node=root.left;
        root.left=root.right;
        root.right=node;
    }
    public List<Integer> printNodeAtK(int K){
        List<Integer> result=new ArrayList<>();
        printNodeAtK(root,K,result);
        return result;
    }
    private void printNodeAtK(Node root2, int k, List<Integer> result) {
        if(root2==null)return;
        if(k==0){
            result.add(root2.value);
            return;
        }
        printNodeAtK(root2.left, k-1,result);
        printNodeAtK(root2.right, k-1,result);
    }
    public void deleteNode(int key){
        root=deleteNode(root,key);
    }
    private Node deleteNode(Node root, int key) {
        if(root==null)return root;
        if(key<root.value){
            root.left=deleteNode(root.left,key);
        } else if(key>root.value){
            root.right=deleteNode(root.right,key);
        } else{
            if(root.left==null)return root.right;
            if(root.right==null)return root.left;
            root.value=findMinimum(root.right);
            root.right=deleteNode(root.right,root.value);
        }
        return root;
        
    }
    private int findMinimum(Node node){
        int min=node.value;
        while(node.left!=null){
            min=node.left.value;
            node=node.left;
        }
        return min;
    }
}
