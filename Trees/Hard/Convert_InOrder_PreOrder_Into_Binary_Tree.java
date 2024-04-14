package Trees.Hard;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Convert_InOrder_PreOrder_Into_Binary_Tree {
    public static void main(String[] args) {
        int[]porder = {10,20,40,50,30,60};
        int[]iorder = {40,20,50,10,60,30};

        Map<Integer , Integer> inMap = new HashMap<>();
        for(int i  =0 ; i<iorder.length; i++){
            inMap.put(iorder[i]  , i );
        }

        TreeNode root = call(porder, 0, porder.length-1 , iorder , 0 , iorder.length -1  , inMap);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
    public static TreeNode call(int[]porder, int pstart, int pend , int[]iorder, int istart , int iend , Map<Integer , Integer>inMap){
        if(pstart > pend || istart > iend) return null;

        TreeNode root = new TreeNode(porder[pstart]);

        int iRoot = inMap.get(root.val);
        int numsLeft = iRoot - istart;

        root.left = call(porder , pstart+1 , pstart+ numsLeft , iorder , istart , iRoot-1 , inMap);
        root.right = call(porder , pstart + numsLeft+1 , pend , iorder , iRoot+1 , iend , inMap);
        return root;
    }
}
