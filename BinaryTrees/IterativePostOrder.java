package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {

    //using a single stack
    public List<Integer> postorder(TreeNode root){
        Stack<TreeNode> st=new Stack<>();
        List<Integer> ans=new ArrayList<>();

        if(root==null) return ans;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            ans.add(0,node.val);
            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);
        }
        return ans;
    }



    //using 2 stacks
    public List<Integer> postorder2(TreeNode root){
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        List<Integer> ans=new ArrayList<>();

        if(root==null) return ans;
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode node=st1.pop();
            st2.push(node);
            if(node.left!=null) st1.push(node.left);
            if(node.right!=null) st2.push(node.right);
        }

        while(!st2.isEmpty()){
            ans.add(st2.pop().val);
        }
        return ans;
    }
}
