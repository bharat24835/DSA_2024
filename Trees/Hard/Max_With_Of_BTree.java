package Trees.Hard;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Max_With_Of_BTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(6);
        System.out.println(call(root));
    }
    public static int call(TreeNode root){
        int max = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root ,0));

        while(!q.isEmpty()){
            int size = q.size();
            int leftmin  =Integer.MAX_VALUE;
            int rightmax = 0;

            for(int i = 0; i<size ; i++){
                Pair temp = q.poll();
                TreeNode node = temp.node;
                int dis = temp.side;
                leftmin = Math.min(leftmin,dis);
                rightmax = Math.max(rightmax, dis);

                if(node.left!= null) q.offer(new Pair(node.left,2*dis+1));
                if(node.right!= null) q.offer(new Pair(node.right,2*dis+2));
            }
            max = Math.max(max , rightmax- leftmin+1);

        }
        return max;

    }
    public static class  Pair{
        TreeNode node;
        int side;
        Pair(TreeNode x, int y){
            this.node = x;
            this.side = y;
        }
    }
}
