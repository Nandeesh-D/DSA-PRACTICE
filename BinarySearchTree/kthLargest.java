package BinarySearchTree;

public class kthLargest {
    int counter=0;
    int kthLargest=0;
    public int KthLargest(TreeNode root, int k) {
        helper(root,k);
        return kthLargest;
    }

    public void helper(TreeNode root,int k){
        if(root==null) return;
        helper(root.right,k);
        counter++;
        if(counter==k){
            kthLargest=root.val;
            return;
        }
        helper(root.left,k);
    }
}
