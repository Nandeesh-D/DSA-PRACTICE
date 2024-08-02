package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> adj=getAdj(prerequisites,numCourses);
        int[] indegree=new int[numCourses];
        //find in degree of all the nodes
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        //add all the nodes having indegree==0 to the queue
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }

        int cnt=0; //to count how many courses are completed
        while (!q.isEmpty()){
            int node=q.poll();
            cnt++;
            //remove the current node and decrease the indegree of its adjacent nodes by 1
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        //if courses completed== numCourses then return true otherwise false
        return cnt==numCourses;
    }

    private List<List<Integer>> getAdj(int[][] prerequisites,int numCourses){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }
        return adj;
    }
}
