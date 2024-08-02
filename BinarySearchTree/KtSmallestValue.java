package BinarySearchTree;

public class KtSmallestValue {
    int counter=0;
    int kthSmallest=0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return kthSmallest;
    }

    public void helper(TreeNode root,int k){
        if(root==null) return;
        helper(root.left,k);
        counter++;
        if(counter==k){
            kthSmallest=root.val;
            return;
        }
        helper(root.right,k);
    }
}
