package Recursion;

import java.util.Arrays;

public class PrintAllPaths {
    public static void main(String[] args) {
        int[][] grid= {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        //printAllPaths("",grid,0,0);
        int[][] path=new int[grid.length][grid[0].length];
        printAllPaths1("",grid,0,0,path,1);
    }
    static void printAllPaths(String p,int[][] grid,int r,int c){
        if(r== grid.length-1 && c==grid[0].length-1){
            System.out.println(p);
            return;
        }

        if(grid[r][c]==1) return;
        grid[r][c]=1;
        //going down
        if(r<grid.length-1) printAllPaths(p+"D",grid,r+1,c);
        //going right
        if(c<grid[0].length-1) printAllPaths(p+"R",grid,r,c+1);
        //going up
        if(r>0) printAllPaths(p+"U",grid,r-1,c);

        //going left
        if(c>0) printAllPaths(p+"L",grid,r,c-1);

        grid[r][c]=0;
    }

    //print path matrix and path
    static void printAllPaths1(String p,int[][] grid,int r,int c,int[][] path,int step){
        if(r== grid.length-1 && c==grid[0].length-1){
            path[r][c]=step;
            for(int[] i:path){
                System.out.println(Arrays.toString(i));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(grid[r][c]==1) return;
        grid[r][c]=1;
        path[r][c]=step;
        //going down
        if(r<grid.length-1) printAllPaths1(p+"D",grid,r+1,c,path,step+1);
        //going right
        if(c<grid[0].length-1) printAllPaths1(p+"R",grid,r,c+1,path,step+1);
        //going up
        if(r>0) printAllPaths1(p+"U",grid,r-1,c,path,step+1);

        //going left
        if(c>0) printAllPaths1(p+"L",grid,r,c-1,path,step+1);

        grid[r][c]=0;
        path[r][c]=0;
    }
}
