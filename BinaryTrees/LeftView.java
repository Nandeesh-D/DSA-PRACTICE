package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        hepler(root,0,ans);
        return ans;
    }

    private static void hepler(TreeNode root,int level,List<Integer> ans){
        if(root==null) return;

        if(ans.size()==level){
            ans.add(root.val);
        }

        //call the left node until no further left will be there
        hepler(root.left,level+1,ans);
        //if not further left child then call the right child
        hepler(root.right,level+1,ans);
    }
}
