package BinaryTrees;

import java.util.ArrayList;

public class RootToSpecifiedNode {

    public static ArrayList<Integer> Path(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();
        int target=7;
        helper(root, ans,target);
        return ans;
    }
    private static boolean helper(TreeNode root,  ArrayList<Integer> ans,int target) {
        if (root == null) {
            return false;    //when node is null and reached end of the path means no target is in the current path
        }

        ans.add(root.val);

        if(root.val==target) return true;

        if (helper(root.left, ans,target) || helper(root.right, ans,target)) {
            return true;
        }

        ans.remove(ans.size() - 1); // Backtrack
        return false;
    }
}
