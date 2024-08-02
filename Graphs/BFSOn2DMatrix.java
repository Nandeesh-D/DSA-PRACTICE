package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSOn2DMatrix {
    public static void main(String[] args) {
        int grid[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        BFSOn2DMatrix b=new BFSOn2DMatrix();
        System.out.println(b.bfs(grid));
    }

    class Pair<T,U>{
        T row;
        U col;
        Pair(T row,U col){
            this.row=row;
            this.col=col;
        }
    }
    public List<Integer> bfs(int[][] grid){
        List<Integer> ans=new ArrayList<>();
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        q.add(new Pair<>(0,0)); //starting point
        vis[0][0]=true;

        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            ans.add(grid[row][col]);
            q.poll();

            //visiting the neighbours
            for(int i=0;i<4;i++){
                int x=row+dRow[i];
                int y=col+dCol[i];

                if(isValid(x,y,vis)){
                    vis[x][y]=true;
                    q.add(new Pair<>(x,y));
                }
            }
        }
        return ans;
    }

    private boolean isValid(int row,int col,boolean[][] vis){
        // If cell lies out of bounds
        if (row < 0 || col < 0 ||
                row >= vis.length || col >= vis[0].length)   //because vis and grid are of same dimensions
            return false;

        // If cell is already visited
        if (vis[row][col])
            return false;

        // Otherwise
        return true;
    }
}


