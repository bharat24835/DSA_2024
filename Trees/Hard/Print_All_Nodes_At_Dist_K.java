package Trees.Hard;

import Trees.TreeNode;

import java.util.*;

public class Print_All_Nodes_At_Dist_K {
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
        int k = 2;
        System.out.println(call(root,root.left ,  k));
    }
    public static List<Integer> call(TreeNode root , TreeNode target, int k){
        List<Integer>ans = new ArrayList<>();
        Map<TreeNode , TreeNode>map  = new HashMap<>();
        make_List(root, map);
        Map<TreeNode , Boolean> visited = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int  dis = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(dis == k )break;
            dis++;

            for(int i = 0 ; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null && visited.get(temp.left) == null){
                    q.offer(temp.left);
                    visited.put(temp.left , true);
                }

                if(temp.right != null && visited.get(temp.right) == null){
                    q.offer(temp.right);
                    visited.put(temp.right , true);
                }

                if(map.get(temp)!= null && visited.get(map.get(temp)) == null){
                    q.offer(map.get(temp));
                    visited.put(map.get(temp) , true);
                }
            }
        }

        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            ans.add(temp.val);
        }
        return ans;
    }
    public static void make_List(TreeNode root , Map<TreeNode, TreeNode> map){

        Queue<TreeNode>q  = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left != null){
                map.put(temp.left , temp);
                q.offer(temp.left);
            }
            if(temp.right != null){
                map.put(temp.right , temp);
                q.offer(temp.right);
            }
        }

    }
}
