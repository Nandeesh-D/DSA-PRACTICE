package BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.*;

public class NodesAtDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Map<TreeNode,TreeNode> parent_track=new HashMap<>();
            markParent(root,parent_track);
            Map<TreeNode,Boolean> visited=new HashMap<>();
            Queue<TreeNode> q=new LinkedList<>();
            q.offer(target);
            visited.put(target,true);
            int distance=0;
            while(!q.isEmpty()){
                int size=q.size();

                if(distance==k) break;
                distance++;
                for(int i=0;i<size;i++){
                    TreeNode cur=q.poll();
                    if(cur.left!=null && visited.get(cur.left)==null){
                        q.offer(cur.left);
                        visited.put(cur.left,true);
                    }

                    if(cur.right!=null && visited.get(cur.right)==null){
                        q.offer(cur.right);
                        visited.put(cur.right,true);
                    }

                    if(parent_track.get(cur)!=null && visited.get(parent_track.get(cur))==false){
                        q.offer(parent_track.get(cur));
                        visited.put(parent_track.get(cur),true);
                    }
                }
            }

            List<Integer> ans=new ArrayList<>();
            while(!q.isEmpty()){
                ans.add(q.poll().val);
            }
            return ans;
    }

    private void markParent(TreeNode root, Map<TreeNode, TreeNode> parent_track){
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
