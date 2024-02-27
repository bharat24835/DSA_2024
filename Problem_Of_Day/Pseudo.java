package Problem_Of_Day;

import java.util.HashSet;
import java.util.Set;

public class Pseudo {
   public static Set<Integer> set  = new HashSet<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);

        root.right   = new TreeNode(1);
        root.right.right   = new TreeNode(1);

        System.out.println(call(root));


    }
    public static int call(TreeNode root){
        set.add(root.val);
        return call1(root);
    }
    public  static  int call1(TreeNode root){
        if(root== null) return 0;
        if(root.left == null && root.right == null){

            return check()? 1:0;
        }


        if(root.left!=null){
            if(set.contains(root.left.val))
                set.remove(root.left.val);
            else set.add(root.left.val);
        }
        int left  = call1(root.left);
        if(root.left!=null){
            if(set.contains(root.left.val))
                set.remove(root.left.val);
            else set.add(root.left.val);
        }

        if(root.right!= null){
            if(set.contains(root.right.val))
                set.remove(root.right.val);
            else set.add(root.right.val);
        }
        int right = call1(root.right);
        if(root.right!= null){
            if(set.contains(root.right.val))
                set.remove(root.right.val);
            else set.add(root.right.val);
        }

        return left+right;

    }
    public static boolean check(){

        if(set.size()==1 || set.size()==0) return true;
        else return false;
    }



}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
