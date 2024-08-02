package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid={
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        MaxAreaOfIsland m=new MaxAreaOfIsland();
        System.out.println(m.maxAreaOfIsland(grid));
    }
    int[][] grid;
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        int maxArea=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxArea=Math.max(maxArea,dfs(i,j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int r,int c){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!=1) return 0;
        grid[r][c]=0;
        int area=1+dfs(r-1,c)+dfs(r,c+1)+dfs(r+1,c)+dfs(r,c-1);
        return area;
    }
}
