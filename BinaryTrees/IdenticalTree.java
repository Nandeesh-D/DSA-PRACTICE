package BinaryTrees;

public class IdenticalTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return p==q;   //pointing to same node or having null

        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);


    }
}
