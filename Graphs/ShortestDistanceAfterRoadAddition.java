package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestDistanceAfterRoadAddition {
    private List<List<int[]>> graph;
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        //constructing adj list
        for(int i=0;i<n-1;i++){
            graph.get(i).add(new int[]{i+1,1});
        }

        int[] res=new int[queries.length];
        int i=0;
        for(int[] query:queries){
            graph.get(query[0]).add(new int[]{query[1],1});
            res[i++]=dijkstra(n);
        }
        return res;
    }

    private int dijkstra(int n){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] ele=pq.peek();
            int node=ele[0];
            int distance=ele[1];
            pq.poll();
            if(node==n-1) return dist[n-1];
            if(distance>dist[node]) continue;
            for(int[] it:graph.get(node)){
                int currNode=it[0];
                int adjDist=it[1];

                if(distance+adjDist<dist[currNode]){
                    dist[currNode]=distance+adjDist;
                    pq.add(new int[]{currNode,dist[currNode]});
                }
            }
        }
        return dist[n-1];
    }
}
