package BinarySearchTree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
            pushAll(root);
    }

    public int next() {
        TreeNode temp=st.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
            return !st.isEmpty();
    }

    //push all the left elements into stack
    private void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
}
