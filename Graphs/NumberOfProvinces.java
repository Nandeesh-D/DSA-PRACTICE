package Graphs;

import java.util.ArrayList;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length+1;
        int vis[] = new int[V];
        int cnt = 0;
        for(int i = 1;i<V;i++) {
            if(vis[i] == 0) {
                cnt++;
                dfs(i, adjList(V, isConnected), vis);
            }
        }
        return cnt;
    }

    public ArrayList<ArrayList<Integer>> adjList(int V, int edges[][]) {

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V+1;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;i++)
        {
            for(int j=0;j<edges.length;j++)
            {
                if(edges[i][j]==1 && i!=j){
                    adj.get(i+1).add(j+1);
                }
            }
        }
        return adj;
    }

    private static void dfs(int node,
                            ArrayList<ArrayList<Integer>> adjLs ,
                            int vis[]) {
        vis[node] = 1;
        for(Integer it: adjLs.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adjLs, vis);
            }
        }
    }
}
