package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteConnectedComponents {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4},
                {3, 5}
        };
        CountCompleteConnectedComponents c=new CountCompleteConnectedComponents();
        System.out.println(c.countCompleteComponents(6,edges));
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean vis[] = new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        int[] cnt={0};
        int[] edgesCount={0};
        int ans=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,adj,cnt,edgesCount);
                if(edgesCount[0]/2==(cnt[0]*(cnt[0]-1)/2)) {
                    ans++;
                }
                cnt[0]=0;
                edgesCount[0]=0;
            }
        }
        return ans;
    }

    public static void dfs(int node, boolean vis[], List<List<Integer>> adj,int[] cnt,int[] edgesCount
    ) {

        // marking current node as visited
        vis[node] = true;
        cnt[0]++;
        edgesCount[0]+= adj.get(node).size();
        //getting neighbour nodes
        for(Integer it: adj.get(node)) {
            if(!vis[it]) {
                dfs(it, vis, adj,cnt,edgesCount);
            }
        }
    }
}
