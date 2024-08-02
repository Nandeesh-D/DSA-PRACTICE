package Recursion;

public class MazeWithObstacles {
    public static void main(String[] args) {
           int[][] grid= {
                   {0,0,0},
                   {0,1,0},
                   {0,0,0}
           };
            printPath("",grid,0,0);
    }

    //only down and right directions are allowed
    static void printPath(String p,int[][] grid,int r,int c){
        if(r== grid.length-1 && c==grid[0].length-1){
            System.out.println(p);
            return;
        }

        if(grid[r][c]==1) return;
        if(r<grid.length-1) printPath(p+"D",grid,r+1,c);
        if(c<grid[0].length-1) printPath(p+"R",grid,r,c+1);
    }

    //including diagonal direction
    static void printPath1(String p,int[][] grid,int r,int c){
        if(r== grid.length-1 && c==grid[0].length-1){
            System.out.println(p);
            return;
        }

        if(grid[r][c]==1) return;
        if(r<grid.length-1 && c<grid[0].length-1) printPath(p+"D",grid,r+1,c+1);
        if(r<grid.length-1) printPath(p+"V",grid,r+1,c);
        if(c<grid[0].length-1) printPath(p+"H",grid,r,c+1);
    }
}
