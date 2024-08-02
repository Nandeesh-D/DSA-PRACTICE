package Graphs;

import java.lang.reflect.GenericDeclaration;
import java.util.*;

public class ShortestPath {

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //preparing the adjacency list
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //distance array to store the distances of each node
        int[] dist=new int[n];
        for(int i=0;i<n;i++) dist[i]=(int)1e9;
        Queue<Integer> q=new LinkedList<>();
        dist[src]=0;
        q.add(src);
        while(!q.isEmpty()){
            int node=q.poll();
            //visit the neighbour nodes
            for(int it:adj.get(node)){
                if(dist[node]+1 <dist[it]){
                    dist[it]=dist[node]+1;
                    q.add(it);
                }
            }
        }

        //if unreachable node are present
        for(int i=0;i<n;i++){
            if(dist[i]==1e9){
                dist[i]=-1;
            }
        }
        return dist;
    }

    //directed acyclic graph with weighted edges
    public int[] shortestPath(int N,int M, int[][] edges) {
        //Code here
        List<List<Pair<Integer,Integer>>> adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        //preparing the adjacency list
        for(int[] edge:edges){
            adj.get(edge[0]).add(new Pair<>(edge[1],edge[2]));
        }
        int[] dist=new int[N];
        Arrays.fill(dist, (int) 1e9);
        Queue<Integer> q=new LinkedList<>();
        dist[0]=0;
        q.add(0);
        while(!q.isEmpty()){
            int node=q.poll();
            //visit the neighbour nodes
            for(Pair<Integer,Integer> p:adj.get(node)){
                int d=(int)p.second;
                int adjNode=(int)p.first;
                if(dist[node]+d<dist[adjNode]){
                    dist[adjNode]=dist[node]+d;
                    q.add(adjNode);
                }
            }
        }

        //if unreachable node are present
        for(int i=0;i<N;i++){
            if(dist[i]==1e9){
                dist[i]=-1;
            }
        }
        return dist;

    }
}


