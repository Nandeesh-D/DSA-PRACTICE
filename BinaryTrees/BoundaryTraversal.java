package BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public List<Integer> boundary(TreeNode root){
            List<Integer> ans=new ArrayList<>();
            if(root==null) return ans;
            ans.add(root.val);
            addLeftBoundary(root,ans);
            addLeafNodes(root,ans);
            addRightBoundary(root,ans);

            return ans;
    }

    private boolean isLeafNode(TreeNode root){
        return root.left==null && root.right==null;
    }
    private void addLeftBoundary(TreeNode root,List<Integer> ans){
        TreeNode cur=root.left;
        while(cur!=null){
            if(!isLeafNode(cur)){
                ans.add(cur.val);
            }

            if(cur.left!=null){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
    }

    private void addLeafNodes(TreeNode root,List<Integer> ans){
        if(isLeafNode(root)){
            ans.add(root.val);
            return;
        }
        if(root.left!=null){
            addLeafNodes(root.left,ans);
        }
        if(root.right!=null){
            addLeafNodes(root.right,ans);
        }
    }

    private void addRightBoundary(TreeNode root,List<Integer> ans){
        TreeNode cur=root.right;
        List<Integer> right=new ArrayList<>();
        while(cur!=null){
            if(!isLeafNode(cur)){
                right.add(cur.val);
            }

            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }

        for(int i=right.size()-1;i>=0;i--){
            ans.add(right.get(i));
        }
    }
}
