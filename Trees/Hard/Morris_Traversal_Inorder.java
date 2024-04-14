package Trees.Hard;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Morris_Traversal_Inorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        call(root);
    }
    public static void call(TreeNode root){
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();

        TreeNode curr = root;

        while(curr!= null){
            if(curr.left == null){
                preOrder.add(curr.val);
                inOrder.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    preOrder.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    inOrder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        System.out.println("PreOrder is : "+ preOrder);
        System.out.println("INOrder is : "+ inOrder);
    }
}
