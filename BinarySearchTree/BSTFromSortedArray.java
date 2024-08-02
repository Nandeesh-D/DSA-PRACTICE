package BinarySearchTree;

public class BSTFromSortedArray {
    TreeNode root;
    public TreeNode getRoot(){
        return root;
    }


    public void constructTree(int[] arr){
            constructTree(arr,0,arr.length);

    }

    public void constructTree(int[] nums,int start,int end){
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        constructTree(nums, start, mid);
        constructTree(nums, mid + 1, end);
    }
    public void insert(int value) {
        root = insert(value, root);
    }

    private TreeNode insert(int value, TreeNode TreeNode) {
        if (TreeNode == null) {
            TreeNode = new TreeNode(value);
            return TreeNode;
        }

        if (value < TreeNode.val) {
            TreeNode.left = insert(value, TreeNode.left);
        }

        if (value > TreeNode.val) {
            TreeNode.right = insert(value, TreeNode.right);
        }

        return TreeNode;
    }
}
