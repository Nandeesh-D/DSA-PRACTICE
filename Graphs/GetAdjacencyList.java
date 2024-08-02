package Graphs;

import java.util.ArrayList;
import java.util.List;

public class GetAdjacencyList {
    public static void main(String[] args) {
        int[][] arr={{0,1,1,0,0},
                {1,0,1,1,0},
                {1,1,0,0,1},
                {0,1,0,0,1},
                {0,0,1,1,0}
        };
        int[][] edges={{0, 1},{0,2},{1,3},{1,4},{2,4}};
        int i=0;
        for(List<Integer> l:adjList1(edges,5)){

            System.out.println(i+" --> "+l);
            i++;
        }
    }
    public static List<List<Integer>> adjList(int[][] matrix,int nodes){
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i!=j && matrix[i][j]==1){
                    list.get(i).add(j);
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> adjList1(int[][] edges,int nodes){
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        return list;
    }
}
