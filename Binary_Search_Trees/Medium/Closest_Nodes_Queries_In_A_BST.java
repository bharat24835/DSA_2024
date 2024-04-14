package Binary_Search_Trees.Medium;

import Binary_Search_Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Closest_Nodes_Queries_In_A_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);

        root.right.right.left = new TreeNode(14);

        int[]queries = {2,5,16};

        System.out.println(call(root , queries));

    }
    public static List<List<Integer>> call(TreeNode root , int[]queries){
        List<List<Integer>>outer = new ArrayList<>();
        for(int i = 0 ; i<queries.length ; i++){
            List<Integer>inner = new ArrayList<>();
            int min = floor(root , queries[i]);
            int max = ceil(root , queries[i]);
            inner.add(min);
            inner.add(max);
            outer.add(inner);
        }

        return outer;
    }
    public static int ceil(TreeNode root , int input){
        int ceil = -1;

        while(root != null){
            if(root.val == input ) return input;
            if(root.val > input){
                ceil = root.val;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;

    }

    public static int floor(TreeNode root , int input){
        int floor = -1;


        while(root != null){

            if(root.val == input)return input;
            if(root.val > input){
                root = root.left;
            }
            else{
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }
}
