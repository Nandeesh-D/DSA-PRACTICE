package BinarySearchTree;

public class InorderPredecessor {
    public static TreeNode inorderPredecessor(TreeNode root,int val){
        TreeNode predecessor=null;
        while(root!=null){
            if(root.val>val){
                root=root.left;
            }
            if(root.val<val){
                predecessor=root;
                root=root.right;
            }

        }
        return predecessor;
    }



    static TreeNode predecessor = null;

    public static TreeNode predecessor(TreeNode root, int target) {
        helper(root, target);
        return predecessor;
    }

    public static void helper(TreeNode root, int target) {
        if (root == null)
            return;

        if (root.val < target) {
            predecessor = root;  // Update predecessor only when moving to the right subtree
            helper(root.right, target);
        } else {
            helper(root.left, target);
        }
    }

}
