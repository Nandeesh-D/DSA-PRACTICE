package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:times){
            adj.get(arr[0]).add(new int[]{arr[1],arr[2]});
        }

        int[] dist=new int[n+1];
        Arrays.fill(dist,(int)1e8);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] arr=pq.peek();
            int node=arr[0];
            int time=arr[1];
            pq.poll();

            for(int[] it:adj.get(node)){
                int curNode=it[0];
                int adjTime=it[1];

                if(time+adjTime<dist[curNode]){
                    dist[curNode]=time+adjTime;
                    pq.add(new int[]{curNode,dist[curNode]});
                }
            }
        }
        int max=0;
        for(int i=1;i<n+1;i++){
            if(dist[i]==1e8) return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}
