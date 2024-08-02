package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int n=graph[0].length;
        int[] colored=new int[graph.length];
        Arrays.fill(colored,-1);

        for(int i=0;i<m;i++){
            if(colored[i]==-1){
                if(!dfs(i, colored,0, graph)) return false;
            }
        }
        return true;
    }

    public static boolean dfs(int node, int colored[],int col, int[][] adj) {

        // marking current node as visited
        colored[node] = col;

        //getting neighbour nodes
        for(int it: adj[node]) {
            if(colored[it]==-1) {
                if(!dfs(it, colored,1-col, adj)) return false;
            }
            //if prev node and curr node have the same color
            else if(colored[it]==col) return false;
        }
        return true;
    }
}
