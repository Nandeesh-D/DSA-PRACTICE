package Graphs;

import java.util.PriorityQueue;

//problem:1631
public class PathWithMinEffort {
    class Tuple{
        int effort,row,col;
        Tuple(int effort,int row,int col){
            this.effort=effort;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
            int m=heights.length;
            int n=heights[0].length;
            if(m==1 && n==1) return 0;
            PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.effort-b.effort);
            //declare a minEffort grid to store the min effort required to reach each cell
            int[][]  minEffort=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    minEffort[i][j]=(int)1e9;
                }
            }
            minEffort[0][0]=0;
            pq.add(new Tuple(0,0,0));

            int[] dRow={-1,0,1,0};
            int[] dCol={0,1,0,-1};
            while(!pq.isEmpty()){
                int effort=pq.peek().effort; //effort of parent cell
                int row=pq.peek().row;
                int col=pq.peek().col;
                pq.poll();

                if(row==m-1 && col==n-1) return effort;
                for(int i=0;i<4;i++){
                    int x=row+dRow[i];
                    int y=col+dCol[i];

                    if(x>=0 && x<m && y>=0 && y<n){
                        // Effort can be calculated as the max value of differences
                        // between the heights of the node and its adjacent nodes.
                        int curEffort=Math.max(Math.abs(heights[x][y]-heights[row][col]),effort);

                        if(curEffort<minEffort[x][y]){
                            minEffort[x][y]=curEffort;
                            pq.add(new Tuple(curEffort,x,y));
                        }
                    }
                }
            }
            return 0;

    }
}
