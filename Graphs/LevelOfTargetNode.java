package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfTargetNode {
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        boolean[] vis=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        int level=0;
        if(X==0) return 0;
        while(!q.isEmpty()){

            int size=q.size();
            for(int j=0;j<size;j++){   //represents each level
                int node=q.poll();
                for(Integer i:adj.get(node)){

                    if(!vis[i]){
                        if(i==X) return level+1;
                        vis[i]=true;
                        q.add(i);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
