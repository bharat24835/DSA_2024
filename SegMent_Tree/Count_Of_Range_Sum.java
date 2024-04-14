package SegMent_Tree;

public class Count_Of_Range_Sum {
    public static void main(String[] args) {
        int[]a = {0,-3,-3,1,1,2};
        int n = a.length-1;
        int lower = 3;
        int upper = 5;
        Node root = construct_segment_tree(a , 0 , n);

        System.out.println(call(root , lower ,upper ));
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

    public static int call(Node root , int lower , int upper){
        if(root.left == null  && root.right == null){
            if(root.data >= lower && root.data<= upper)return 1;
            else return 0;
        }
        int left = (root.left != null ? call(root.left , lower , upper) : 0);
        int right = (root.right != null ? call(root.right , lower , upper) : 0);

        int count =0;
        if(root.data >= lower && root.data <= upper)count++;

        return left+right+count;
    }
}
