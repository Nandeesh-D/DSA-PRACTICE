package BinarySearchTree;

public class MinValueInBST {
    int minValue(TreeNode root) {
        // code here
        if(root.left==null) return  root.val;

        return minValue(root.left);
    }
}
