package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // priority queue to store the node and distance pairs and store them in ascending order of their distances
        PriorityQueue<Pair<Integer,Integer>> q=new PriorityQueue<>((a,b)-> a.second-b.second);
        //to keep the shortest distance from the source to each node
        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S]=0;
        q.add(new Pair<>(S,0));
        while(!q.isEmpty()){
            int node=q.peek().first;
            q.poll();

            for(int i=0;i<adj.get(node).size();i++){
                int adjDist=adj.get(node).get(i).get(1);
                int adjNode=adj.get(node).get(i).get(0);

                if(dist[node]+adjDist < dist[adjNode]){
                    dist[adjNode]=dist[node]+adjDist;
                    q.add(new Pair<>(adjNode,dist[adjNode]));
                }
            }
        }
        return dist;

    }
}
