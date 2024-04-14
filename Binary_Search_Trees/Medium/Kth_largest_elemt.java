package Binary_Search_Trees.Medium;

import Binary_Search_Trees.TreeNode;

public class Kth_largest_elemt {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        int k = 3;
        char s = ' ';
        //System.out.println((int)s);
        System.out.println(call(root ,k ));
    }
    public static int call(TreeNode root  , int k){
        int counter = 0 ;
        int ans = 0;
        TreeNode curr =root;

        while(curr != null){

            // Case 1 : when left is null
            if(curr.left == null){
                counter++;
                if(counter == k){
                    ans = curr.val;
                }
                curr = curr.right;
            }
            else{   // Case 2 : when left is not null
                TreeNode prev = curr.left;
                while(prev.right!= null && prev.right != curr){
                    prev = prev.right;
                }
                // connecting and disconnecting thread
                if(prev.right == null){
                    // connect the node and move to the left
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    // disconnect the thread and move to right
                    prev.right = null;
                    counter++;
                    if(counter == k)
                        ans = curr.val;
                    curr = curr.right;
                }

            }
        }
        return ans;
    }
}
