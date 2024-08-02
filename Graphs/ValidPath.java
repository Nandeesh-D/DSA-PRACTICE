package Graphs;

import java.util.ArrayList;

public class ValidPath {
    public static void main(String[] args) {
        int[][] edges={{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        ValidPath v=new ValidPath();
        System.out.println(v.validPath(10,edges,7,5));
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis=new boolean[n];
        dfs(source,vis,adjList(edges,n));
        return vis[destination];
    }

    private ArrayList<ArrayList<Integer>> adjList(int[][] edges,int n){
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        // marking current node as visited
        vis[node] = true;

        // getting neighbour nodes
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj);
            }
        }
    }
}
