package AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
   public class AVLNode{
        int value;
        int height;
        AVLNode left;
        AVLNode right;
        public AVLNode(int val){
            this.value=val;
        }
        // @Override
        // public String toString(){
        //     return "value="+this.value;
        // }

    }
   public AVLNode root;
    public void insert(int n){
        root = insert(root,n);
    }
    private AVLNode insert(AVLNode node, int n) {
        if(node==null){
            return new AVLNode(n);
        }
        if(node.value<n){
            node.right=insert(node.right,n);
        }else{
            node.left=insert(node.left,n);
        }
        setHeight(node);;
        return balance(node);
    }
    private AVLNode balance(AVLNode node){
        if(isRightHeavy(node)){
            if(balanceFactor(node.right)>0){
                node.right=rotateRight(node.right);
            }
            node=rotateLeft(node);
        } else if(isLeftHeavy(node)){
            if(balanceFactor(node.left)<0)
            node.left=rotateLeft(node.left);
            rotateRight(node);
        }
        return node;
    }
    private AVLNode rotateLeft(AVLNode node){
        AVLNode newNode = node.right;
        node.right=newNode.left;
        newNode.left=node;
        setHeight(node);
        setHeight(newNode);
        return newNode;
    }
    private AVLNode rotateRight(AVLNode node){
        AVLNode newNode=node.left;
        node.left=newNode.right;
        newNode.right=node;
        setHeight(node);
        setHeight(newNode);
        return newNode;
    }
    private void setHeight(AVLNode node){
        node.height=Math.max(height(node.left),height(node.right))+1;
    }
    public int height(AVLNode node){
        if(node==null)return -1;
        return node.height;
    }
    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) >1;
    }
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) <-1;
    }
    private int balanceFactor(AVLNode node){
       return  node==null? 0 : height(node.left)-height(node.right);
    }

    public void print(){
        Queue<AVLNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            AVLNode node=q.poll();
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
            System.out.print(node.value+" ");
        }
        System.out.println();
    }
    
}
