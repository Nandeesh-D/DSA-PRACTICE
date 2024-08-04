package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgo {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[S]=0;
        for(int i=0;i<V-1;i++){
            for(int j=0;j<edges.size();j++){
               int u=edges.get(j).get(0);
               int v=edges.get(j).get(1);
               int dis=edges.get(j).get(2);

               if(dist[u]!=1e8 && dist[u]+dis<dist[v]){
                   dist[v]=dist[u]+dis;
               }
            }
        }
        //checking for negative cycle
        for(int j=0;j<edges.size();j++){
            int u=edges.get(j).get(0);
            int v=edges.get(j).get(1);
            int dis=edges.get(j).get(2);

            if(dist[u]!=1e8 && dist[u]+dis<dist[v]){ //if found then return -1
                return new int[]{-1};
            }
        }
        return dist;
    }
}
