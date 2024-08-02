package BinaryTrees;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxSum={Integer.MIN_VALUE};
        helper(root,maxSum);
        return maxSum[0];
    }


    private int helper(TreeNode root,int[]maxSum){
        if(root==null) return 0;

        //if ls or rs is getting 0 means we never get maximum sum from this so consider them to be zero
        int ls=Math.max(0,helper(root.left,maxSum));
        int rs=Math.max(0,helper(root.right,maxSum));

        maxSum[0]=Math.max(maxSum[0],ls+rs+root.val);

        return root.val+Math.max(ls,rs);
    }
}
