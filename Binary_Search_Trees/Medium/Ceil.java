package Binary_Search_Trees.Medium;

import Binary_Search_Trees.TreeNode;

public class Ceil {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);

        root.right.right.left = new TreeNode(14);

        int k = 5;
        System.out.println(call(root , root.val , k));

    }
    public static int call(TreeNode root , int value , int k){
        if(root == null) return value;

        if(root.val == k)return k;
        if( root.val > k ) return call(root.left , root.val , k);
        else {
            return call(root.right , value , k);
        }

    }
}
