package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        hepler(root,0,ans);
        return ans;
    }

    private static void hepler(TreeNode root,int level,List<Integer> ans){
        if(root==null) return;

        if(ans.size()==level){
            ans.add(root.val);
        }

        //call the right node until no further right will be there
        hepler(root.right,level+1,ans);
        //if not further right child then call the left child
        hepler(root.left,level+1,ans);
    }
}
