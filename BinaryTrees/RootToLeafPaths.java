package BinaryTrees;

import java.util.ArrayList;

public class RootToLeafPaths {

    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(root, ans, temp);
        return ans;
    }

    private static void helper(TreeNode root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp) {
        if (root == null) {
            return;
        }

        temp.add(root.val);

        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(temp)); // Add a copy of temp when we reach a leaf
        } else {
            helper(root.left, ans, temp);
            helper(root.right, ans, temp);
        }

        temp.remove(temp.size() - 1); // Backtrack
    }
}
