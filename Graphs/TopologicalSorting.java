package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] vis=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,st,vis);
            }
        }

        int[] ans=new int[V];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]=st.pop();
        }
        return ans;
    }
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] vis){
        vis[node]=true;

        for(int i:adj.get(node)){
            if(!vis[i]){
                dfs(i,adj,st,vis);
            }
        }
        st.push(node);
    }


}
