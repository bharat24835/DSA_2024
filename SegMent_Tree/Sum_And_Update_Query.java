package SegMent_Tree;

public class Sum_And_Update_Query {
    public static void main(String[] args) {
        int[]a = {3,8,7,6,-2,-8,4,9};
        int n = a.length-1;

        Node root = construct_segment_tree(a , 0 , n);
        int qs = 1;
        int qe = 5;
        int index = 3;
        int value = 4;
        System.out.println(sum(root ,2 ,3 ));
        update(root , index , value);
        System.out.println(sum(root,2,3));
    }


    public  static int sum(Node root , int qstart , int qend){
        // there are 3 conditions
        // 1- No overlapping
        if(root.startInterval > qend || root.endInterval < qstart) return 0;

        // 2 - Completelu inside
        if(qstart <= root.startInterval && root.endInterval <= qend) return root.data;

        // 3 Partial overlapping
        // in that case we go for PostOrder
        int left = sum(root.left , qstart ,qend);
        int right = sum(root.right , qstart , qend);

        return left+right;
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

    public static void update(Node root , int index , int value){
        if(root.startInterval == index && root.endInterval == index){

            root.data = value;
            return;
        }

        // 2 Condition

        // 1- Completrly outside
        if(root.startInterval> index || root.endInterval < index) return;
        else{
            int mid   = (root.startInterval + root.endInterval)/2;
            if(index <= mid){
                update(root.left , index , value);
                root.data = root.left.data + root.right.data;
            }
            else{
                update(root.right , index , value);
                root.data = root.left.data + root.right.data;
            }
        }

        return;
    }
}
