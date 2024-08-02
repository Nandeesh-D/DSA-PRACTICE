package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CountUnreachablePairsOfNodes {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean vis[] = new boolean[n];
        long total=0;
        long ans=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                long nodes=(long)dfs(i, vis, list);
                ans+=(total*nodes);
                total+=nodes;
            }
        }
        return ans;
    }
    public static long dfs(int node, boolean[] vis, List<List<Integer>> adj) {
        // marking current node as visited
        vis[node] = true;

        long size = 1; // Initialize size to 1 to count the current node

        // getting neighbour nodes
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                size += dfs(it, vis, adj);
            }
        }

        return size;
    }
}
