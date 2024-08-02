package BinarySearchTree;

public class MaxValueInBST {
    int maxValue(TreeNode root) {
        // code here
        if(root.right==null) return  root.val;

        return maxValue(root.right);
    }
}
