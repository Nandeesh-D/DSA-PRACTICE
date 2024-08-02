package BinaryTrees;

public class DiameterOfBTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxHeight={0};
        helper(root,maxHeight);

        return maxHeight[0];
    }

    private int helper(TreeNode root, int[] maxHeight) {
        if(root==null) return 0;
        int lh=helper(root.left,maxHeight);
        int rh=helper(root.right,maxHeight);
        if(lh+rh > maxHeight[0]) maxHeight[0]=lh+rh;

        return 1+Math.max(lh,rh);
    }
}
