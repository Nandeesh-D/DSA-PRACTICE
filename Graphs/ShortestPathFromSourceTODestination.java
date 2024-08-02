package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathFromSourceTODestination {
    public List<Integer> shortestPath(int n, int m, int[][] edges){
        ArrayList<ArrayList<Pair<Integer,Integer>>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        //building adjacency matrix
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair<>(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair<>(edges[i][0],edges[i][2]));
        }

        PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>((a,b)-> a.second-b.second);
        int[] dist=new int[n+1];
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=(int)1e9;
            parent[i]=i;
        }

        dist[1]=0;
        pq.add(new Pair<>(1,0));
        while(!pq.isEmpty()){
            int node=pq.peek().first;
            int dis=pq.peek().second;
            pq.poll();

            for(Pair<Integer,Integer> it:adj.get(node)){
                int adjNode=it.first;
                int adjDis=it.second;
                if(dis+adjDis<dist[adjNode]){
                    dist[adjNode]=dis+adjDis;
                    pq.add(new Pair<>(adjNode,dist[adjNode]));
                    parent[adjNode]=node;
                }
            }
        }

        List<Integer> path=new ArrayList<>();
        if(dist[n]==1e9){  //if destination is unreachable
            path.add(-1);
            return path;
        }

        int node=n;
        //until it is not a source node
        while(parent[node]!=node){
            path.add(0,node);
            node=parent[node];
        }
        path.add(node);
        return path;
    }
}
