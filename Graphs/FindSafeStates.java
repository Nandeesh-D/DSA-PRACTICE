package Graphs;

import java.util.*;

public class FindSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree=new int[graph.length];
        //now we get adj as the reversed edges
        for(int i=0;i<graph.length;i++){
            for(int it:graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int node=q.poll();
            safeNodes.add(node);

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;


    }
}
