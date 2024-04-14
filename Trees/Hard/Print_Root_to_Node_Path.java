package Trees.Hard;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Print_Root_to_Node_Path {
    public static List<Integer> outer   = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);

    //    List<Integer> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        List<Integer> inner1 = new ArrayList<>();
        int target = 7;
        call(node,target,inner);
       boolean temp =  call1(node,target, inner1);
        System.out.println(outer);
        System.out.println(inner1);
    }
    public static void call(TreeNode root,int target, List<Integer>inner){

        if(root == null )return;

        inner.add(root.val);
        if(root.val == target){
            outer = new ArrayList<>(inner);
        }

        call(root.left,target, inner);
        call(root.right,target, inner);

        inner.remove(inner.size()-1);
        return;
    }

    public static boolean call1(TreeNode node, int target,List<Integer>inner){

        if(node == null) return false;

        inner.add(node.val);
        if(node.val == target)return true;

        if(call1(node.left,target,inner) || call1(node.right,target,inner)) return true;

        inner.remove(inner.size()-1);
        return false;

    }
}
