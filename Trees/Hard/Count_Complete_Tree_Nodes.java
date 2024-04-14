package Trees.Hard;

import Trees.TreeNode;

public class Count_Complete_Tree_Nodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);
        System.out.println(call(root));
    }
    public static int call(TreeNode root){
        if(root == null) return 0;
        int left = leftheight(root);
        int right = rightHeight(root);

        if(left == right) return (int)Math.pow(2,left)-1;
        else return  1 + call(root.left) +call(root.right);

    }
    public static int leftheight(TreeNode root){

        int count = 0 ;
        while (root.left!= null){
            count++;
            root  = root.left;
        }
        return count;
    }
    public static int rightHeight (TreeNode root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }

}
