package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinTimeToBurnTheTree {
    public static int minTime(TreeNode root, int target)
    {
        // Your code goes here
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        markParent(root,parent_track);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode tar=findTargetNode(root,target);
        q.offer(tar);
        visited.put(tar,true);
        int min=0;
        while(!q.isEmpty()){
            int size=q.size();
            int flag=0;

            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null && visited.get(cur.left)==null){
                    flag=1;
                    q.offer(cur.left);
                    visited.put(cur.left,true);
                }

                if(cur.right!=null && visited.get(cur.right)==null){
                    flag=1;
                    q.offer(cur.right);
                    visited.put(cur.right,true);
                }

                if(parent_track.get(cur)!=null && visited.get(parent_track.get(cur))==null){
                    flag=1;
                    q.offer(parent_track.get(cur));
                    visited.put(parent_track.get(cur),true);
                }
            }
            if(flag==1) min++;   //burnt some neighbours
        }
        return min;
    }



    //finds the target node
    private static TreeNode findTargetNode(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        // Search in the left subtree
        TreeNode leftResult = findTargetNode(root.left, target);
        if (leftResult != null) {
            return leftResult;
        }
        // Search in the right subtree
        return findTargetNode(root.right, target);
    }

    private static void markParent(TreeNode root, Map<TreeNode, TreeNode> parent_track){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null) {
                parent_track.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null){
                parent_track.put(current.right,current);
                q.offer(current.right);
            }
        }
    }
}
