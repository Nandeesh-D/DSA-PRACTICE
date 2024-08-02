package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {
    public List<Integer> inorder(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();

        while(true){
            if(root!=null){
                st.push(root);
                root=root.left;
            }else{
                if(st.isEmpty()) break;
                root=st.pop();
                ans.add(root.val);
                root=root.right;
            }
        }
        return ans;
    }
}
