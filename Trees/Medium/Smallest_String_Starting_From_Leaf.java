package Trees.Medium;

import Trees.TreeNode;

public class Smallest_String_Starting_From_Leaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);

        System.out.println(call(root));
    }
    public static String call(TreeNode root){
        if(root == null)
            return "";

        String left = call(root.left);
        String right = call(root.right);

        // checking string back
        int n_left = left.length();
        int n_right = right.length();

        int l = 0 ;
        int r = 0 ;

        while( l < n_left && r < n_right){
            if(left.charAt(l) < right.charAt(r)){
                return left+ (char)(root.val + (int)'a');
            }
            else if (left.charAt(l) > right.charAt(r)){
                return right + (char)(root.val + (int)'a');
            }
            else{
                l++;
                r++;
            }
        }

        return l == n_left ?  right + (char)(root.val + (int)'a') : left+ (char)(root.val + (int)'a') ;
    }
}
