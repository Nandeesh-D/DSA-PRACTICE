package BinaryTrees;

public class BalancedOrNot {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root){
        if(root==null) return 0;
        int lh=helper(root.left);
        int rh=helper(root.right);
        if(Math.abs(lh-rh)>1) return -1;   //tree is not balanced
        if(lh==-1 || rh==-1) return -1;   //means the subtree is not balanced
        return 1+Math.max(lh,rh);
    }
}
