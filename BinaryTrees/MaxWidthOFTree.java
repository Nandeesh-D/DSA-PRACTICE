package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOFTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            //find min index in the current level
            int lmin=q.peek().index;
            int first=0,last=0;

            for(int i=0;i<size;i++){
                int cur_ind=q.peek().index-lmin;
                TreeNode node=q.peek().node;
                q.poll();
                if(i==0) first=cur_ind;
                if(i==size-1) last=cur_ind;
                if(node.left!=null) q.add(new Pair(node.left,cur_ind*2+1));
                if (node.right!=null) q.add(new Pair(node.right,cur_ind*2+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;

    }
}

class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
}
