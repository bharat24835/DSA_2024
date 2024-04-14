package Binary_Search_Trees.Medium;

import Binary_Search_Trees.TreeNode;

public class Insert_Noe {
    public static void main(String[] args) {
        TreeNode root  = new TreeNode(10);

        root.left   = new TreeNode(5);
        root.right  = new TreeNode(11);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        root.left.right.right = new TreeNode(8);

       int k = 6;
        TreeNode root1 = call(root , k);
        System.out.println(root1.val);
    }
    public static TreeNode  call(TreeNode root , int k){
        if(root == null){
            return  new TreeNode(k);
        }
        TreeNode curr = root;

        while(true){
            if(curr.val <= k){
                if(curr.right!= null ){
                    curr = curr.right;
                }
                else{
                    curr.right = new TreeNode(k);
                    break;
                }
            }
            else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(k);
                    break;
                }
            }
        }
            return root;
    }
}
