package Binary_Search_Trees.Medium;

import Binary_Search_Trees.TreeNode;

public class Longest_Unilevel_Path {
    public  static  int ans =0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        root.right.right = new TreeNode(5);
        System.out.println(call(root));
        System.out.println(ans);
    }
    public static int call(TreeNode root){
        int temp = call1(root);
        return ans;
    }
    public static int call1(TreeNode root){
        if(root == null) return 0;

        int left = call1(root.left);
        int right = call1(root.right);

        int count_left = 0;
        int count_right = 0;

        if(root.left != null && root.left.val == root.val){
            count_left+= left+1;
        }
        if(root.right != null && root.right.val == root.val){
            count_right+= right+1;
        }
        ans = Math.max(ans , count_left + count_right);
        return Math.max(count_right, count_left);
    }
}
