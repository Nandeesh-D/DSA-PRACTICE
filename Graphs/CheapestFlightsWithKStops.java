package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithKStops {
    class Pair{
        int node;
        int cost;
        Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }

    class Tuple{
        int stops;
        int node;
        int cost;

        Tuple(int stops,int node,int cost){
            this.stops=stops;
            this.node=node;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src==dst) return 0;
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Tuple(0,src,0));
        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        dist[src] = 0;

        while(!pq.isEmpty()){
            Tuple t=pq.peek();
            pq.poll();
            int stops=t.stops;
            int node=t.node;
            int cost=t.cost;

            if(stops>k) continue;
            for(Pair it:adj.get(node)){
                int adjNode=it.node;
                int currCost=it.cost;
                if(cost+currCost<dist[adjNode] && stops<=k){
                    dist[adjNode]=cost+currCost;
                    pq.add(new Tuple(stops+1,adjNode,dist[adjNode]));
                }
            }

        }
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
    }
}
