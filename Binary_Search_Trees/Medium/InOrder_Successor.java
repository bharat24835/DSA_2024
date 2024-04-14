package Binary_Search_Trees.Medium;

import Binary_Search_Trees.TreeNode;
import com.sun.source.tree.Tree;

public class InOrder_Successor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(10);

        int val = 10;

        System.out.println(call(root , val));
    }
    public static int call(TreeNode root , int val){
        int ans  = root.val;

        TreeNode curr = root;

        while(curr!= null){
            if(curr.val > val){
                ans = curr.val;
                curr = curr.left;
            }
            else {
              //  if(curr.right!= null)ans = curr.right.val;
                curr = curr.right;
            }
        }
        return  ans;
    }
}
