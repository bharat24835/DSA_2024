package SegMent_Tree;

public class Node {
    public int data;
    public int startInterval ;
    public int endInterval;
    public Node left;
    public Node right;

    public Node (int s , int e){
        this.startInterval = s;
        this.endInterval = e;
    }
    public Node (int data , int s, int e){
        this.data = data;
        this.startInterval = s;
        this.endInterval = e;
        this.left = null;
        this.right = null;
    }
    public Node (int data , int s, int e, Node left , Node right){
        this.data = data;
        this.startInterval = s;
        this.endInterval = e;
        this.left = left;
        this.right = right;
    }

}
