package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBTree {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //maxdepth is the level of a node in the last level
    public int maxDepth1(TreeNode root) {
        if(root==null) return 0;
        int level=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            level++;
        }
        return level;
    }

}
