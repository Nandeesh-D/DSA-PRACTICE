package BinarySearchTree;

public class RecoverBST {
    TreeNode prev=null,first=null,second=null;
    // Inorder traversal of bst given array of integers in increasing order
    // so detect the 2 break points i.e first and second using inorder traversal
    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && (root.val< prev.val)){
            if(first==null) first=root;
            second=root;
        }
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
         inorder(root);
         int t=first.val;
         first.val=second.val;
         second.val=t;
    }
}
