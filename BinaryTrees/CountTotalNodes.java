package BinaryTrees;

public class CountTotalNodes {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int lh=findHeightLeft(root);
        int rh=findHeightRight(root);

        if(lh==rh){
            return (1<<lh)-1;
        }

        return 1+countNodes(root.left)+countNodes(root.right);

    }


    //finding the height is O(log N) because the tree is complete binary tree

    // Function to find the
    // height of the left subtree
    private int findHeightLeft(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // Function to find the
    // height of the right subtree
    private int findHeightRight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
