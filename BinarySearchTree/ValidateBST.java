package BinarySearchTree;

public class ValidateBST {
    TreeNode prev = null;
    boolean result = true;

    private void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(prev==null) prev=root;
        else if(root.val<=prev.val) result=false;
        else prev=root;
        helper(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return result;
    }
}
