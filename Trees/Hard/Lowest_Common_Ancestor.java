package Trees.Hard;

import Trees.TreeNode;
import com.sun.source.tree.Tree;

public class Lowest_Common_Ancestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

         root.left = new TreeNode(2);
         root.right = new TreeNode(3);

         root.left.left = new TreeNode(4);
         root.left.right = new TreeNode(5);

         root.right.left = new TreeNode(8);
         root.right.right = new TreeNode(9);

         root.left.right.left = new TreeNode(6);
         root.left.right.right = new TreeNode(7);

         int p = 4;
         int q = 7;
       // System.out.println(call(root));
        TreeNode temp =call(root,p,q);
        System.out.println(temp.val);
    }
    public static TreeNode call(TreeNode root, int p , int q){
        if(root == null) return null;

        if(root.val == p || root.val == q) return root;

        TreeNode left = call(root.left,p,q);
        TreeNode right = call(root.right,p,q);

        // we always try to return the non null node
        //

        if(left == null ) return right;
        else if(right == null ) return left;
        else{
            return root;
        }
    }
}
