package Binary_Search_Trees.Medium;

import Binary_Search_Trees.TreeNode;

public class Floor {
    public static void main(String[] args) {
        TreeNode root  = new TreeNode(10);

        root.left   = new TreeNode(5);
        root.right  = new TreeNode(11);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        root.left.right.right = new TreeNode(8);

        int k = 6;
        System.out.println(call(root  , k));
    }
    public static int call(TreeNode root , int input){
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
