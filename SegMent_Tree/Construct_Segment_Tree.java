package SegMent_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Construct_Segment_Tree {
    public static void main(String[] args) {
        int[]a = {3,8,7,6,-2,-8,4,9};
        int n = 8;
        Node root = construct_segment_tree(a ,0, n-1);
        print(root);
    }
    public static  Node construct_segment_tree(int[]a , int start, int end){
        if(start  == end){
            Node node  = new Node(a[start] , start ,end);
            return node;
        }

        int mid = (start+end)/2;
        Node left = construct_segment_tree(a , start ,mid);
        Node right = construct_segment_tree(a , mid+1 , end);


        Node root = new Node(left.data+right.data , start,end , left ,right );
        return root;




    }
    public static void  print(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i<size ; i++){
                Node temp = q.poll();
                list.add(temp.data);

                if(temp.left  != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);

            }
            System.out.println(list);
        }
    }
}
