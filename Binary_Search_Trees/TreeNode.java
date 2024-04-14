package Binary_Search_Trees;

public class TreeNode {
    public int val;
    public TreeNode left ;
    public TreeNode right;
    public TreeNode(int x){
        this.val = x;
        this.left = null;
        this.right = null;
    }
    public  TreeNode(int x,TreeNode left,TreeNode right){
        this.val = x;
        this.left =left;
        this.right = right;
    }

}
