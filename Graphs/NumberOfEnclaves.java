package Graphs;

import java.util.Queue;

public class NumberOfEnclaves {
    static int[] dRow={-1,0,1,0};
    static int[] dCol={0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];

        //finding and adding all the sources
        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && grid[0][i]==1){
                dfs(0,i,grid,vis);
            }
            if(vis[m-1][i]==0 && grid[m-1][i]==1){
                dfs(m-1,i,grid,vis);
            }

        }

        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i,0,grid,vis);
            }
            if(vis[i][n-1]==0 && grid[i][n-1]==1){
                dfs(i,n-1,grid,vis);
            }
        }

        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int row,int col,int[][] grid,int[][] vis){
        vis[row][col]=1;

        for(int i=0;i<4;i++){
            int x=row+dRow[i];
            int y=col+dCol[i];

            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && vis[x][y]==0 && grid[x][y]==1){
                dfs(x,y,grid,vis);
            }
        }
    }
}
