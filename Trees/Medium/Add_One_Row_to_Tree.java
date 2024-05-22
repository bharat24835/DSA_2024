package Trees.Medium;




import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Add_One_Row_to_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        System.out.println("Before Executing Level Tree is : ");
        print(root);
        TreeNode temp = call(root , 1 , 2);
    }
    public static TreeNode call(TreeNode root , int val , int depth){
               if(depth == 1 ){
               TreeNode temp = new TreeNode(val);
               temp.left = root;
               return root;
               }

               int search_depth = depth-1;
               int c_depth = 1;
               Queue<TreeNode>q = new LinkedList<>();
               q.offer(root);

              return  root;

    }
    public static void print(TreeNode root){
        Queue<TreeNode>q = new LinkedList<>();
        TreeNode temp = root;
        q.offer(root);

        while(!q.isEmpty()){


            int size = q.size();
            for(int i = 0  ; i<size ; i++){
                TreeNode node = q.poll();

                System.out.print(node.val + " , ");
                if(node.left != null) q.offer(node.left);
                if(node.right != null )q.offer(node.right);
            }
            System.out.println("");
        }
    }
}
