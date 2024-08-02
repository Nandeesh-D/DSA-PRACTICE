package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    //bfs for both connected and disconnected graph
    public ArrayList<Integer> bfs(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[V];
        ArrayList<Integer> bfs=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                bfsOfGraph(V,adj,visited,bfs);
            }
        }
        return bfs;
    }
    private  void bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj,boolean[] visited,ArrayList<Integer> bfs) {
        // Code here
        Queue<Integer> q=new LinkedList<>();

        q.add(0);     // 0 is the starting node of the graph
        visited[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            for(Integer i:adj.get(node)){
                if(!visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }

    }

    //bfs for connected graph
    private  ArrayList<Integer> bfs1(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[V];
        ArrayList<Integer> bfs=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();

        q.add(0);     // 0 is the starting node of the graph
        visited[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            for(Integer i:adj.get(node)){
                if(!visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }
}
