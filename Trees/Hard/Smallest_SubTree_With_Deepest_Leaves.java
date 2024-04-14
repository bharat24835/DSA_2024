package Trees.Hard;

import Trees.TreeNode;

public class Smallest_SubTree_With_Deepest_Leaves {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(3);

         root.left =new TreeNode(5);
         root.right =new TreeNode(1);

         root.left.left  = new TreeNode(6);
         root.left.right  = new TreeNode(2);
         root.right.left = new TreeNode(0);
         root.right.right = new TreeNode(8);

         root.left.left.left =new TreeNode(10);
         root.left.right.left = new TreeNode(7);
         root.left.right.left = new TreeNode(4);

        System.out.println(call(root).val);


    }

    public static TreeNode call(TreeNode root){
        if(root == null) return null;

        int left_height = height(root.left);
        int right_height = height(root.right);

        if(left_height == right_height) return root;
        else if (left_height > right_height)  return call(root.left);
        else return call(root.right);
    }
    public static int height(TreeNode root){
        if(root == null )return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right)+1;

    }

}
