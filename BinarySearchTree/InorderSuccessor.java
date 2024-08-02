package BinarySearchTree;

public class InorderSuccessor {
    public static TreeNode inorderSuccessor(TreeNode root,int val){
         TreeNode successor=null;
         while(root!=null){
             if(root.val<val){
                 root=root.right;
             }
             if(root.val>val){
                 successor=root;
                 root=root.left;
             }
         }
         return successor;
    }

    static TreeNode  successor=null;
    public static TreeNode successor(TreeNode root,int target){
        helper(root,target);
        return successor;
    }

    public static void helper(TreeNode root,int target){
        if(root==null) return;

        if(root.val>target)
        {
            successor=root;
            helper(root.left,target);
        }
        else helper(root.right,target);


    }
}
