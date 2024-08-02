package Graphs;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V+1];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj,
                           ArrayList<Integer> ls) {

        // marking current node as visited
        vis[node] = true;
        ls.add(node);

        //getting neighbour nodes
        for(Integer it: adj.get(node)) {
            if(!vis[it]) {
                dfs(it, vis, adj, ls);
            }
        }
    }
}
