package Binary_Search_Trees.Medium;

import Binary_Search_Trees.TreeNode;

public class Construct_BST_from_PreOrder {
    public static void main(String[] args) {
        int[]a = {8,5,1,7,10,12};

        System.out.println(call(a , Integer.MAX_VALUE , new int[]{0}).val);
    }
    public static TreeNode call(int[]a , int ub  , int[]i){
        if(i[0] == a.length || a[i[0]] > ub ) return null;

        TreeNode root = new TreeNode(a[i[0]]++);
        root.left = call(a , root.val , i);
        root.right = call(a , ub , i);

        return root;
    }
}
