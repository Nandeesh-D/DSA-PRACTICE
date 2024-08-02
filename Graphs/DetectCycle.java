package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(0,-1,adj,vis))return true;
            }
        }
        return false;
    }

    private boolean bfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[node]=true;
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        q.add(new Pair<>(node,-1));
        while(!q.isEmpty()){
            int data=q.peek().first;
            int parent=q.peek().second;
            q.poll();

            for(Integer adjNode:adj.get(data)){
                if(!vis[adjNode]){
                    vis[adjNode]=true;
                    q.add(new Pair<>(adjNode,node));
                }else if(parent!=adjNode) return true;   //condition for detecting the cycle
            }
        }
        return false;
    }


    //using dfs
    private boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
              vis[node]=true;
              for(Integer it:adj.get(node)){
                  if(!vis[it]){
                      if(dfs(it,node,adj,vis)) return true;
                  }else if(it!=parent) return true;
              }
              return false;
    }
}

class Pair<T,U>{
    T first;
    U second;
    public Pair(T first,U second){
        this.first=first;
        this.second=second;
    }
}
