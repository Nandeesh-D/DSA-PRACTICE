package Graphs;

import java.util.Arrays;

public class ColoringABorder {
    int[][] grid;
    int m,n;

    int[] dRow={-1,0,1,0};
    int[] dCol={0,1,0,-1};
    int[][] vis;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            this.grid=grid;
            this.m=grid.length;
            this.n=grid[0].length;
            this.vis=new int[grid.length][grid[0].length];
            dfs(row,col,grid[row][col],color);
            return grid;
    }

    private void dfs(int r,int c,int prevColor,int color){
            if(vis[r][c]==1) return;
            vis[r][c]=1;
            if(isBoundary(r,c,prevColor)){  //if the cell is boundary cell then color it
                grid[r][c]=color;
            }

            //now apply dfs on all the adjacent nodes to it
            for(int i=0;i<4;i++){
                //adjacent cell
                int x=r+dRow[i];
                int y=c+dCol[i];

                if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==prevColor){
                    dfs(x,y,prevColor,color);
                }
            }


    }
    private boolean isBoundary(int r,int c,int prevColor){
        if((r==0 || c==0 || r==m-1 || c==n-1) && grid[r][c]==prevColor) return true;
        for(int i=0;i<4;i++){
            //adjacent cell
            int x=r+dRow[i];
            int y=c+dCol[i];

            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]!=prevColor){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid={{1,1,1}, {1,1,1},{1,1,1}};;
        ColoringABorder c=new ColoringABorder();
        c.colorBorder(grid,1,1,2);
        for(int[] num:grid){
            System.out.println(Arrays.toString(num));
        }
    }
}
