package Graphs;

import java.util.LinkedList;
import java.util.Queue;

//problem: 1091
public class ShortestPath1 {
    class Tuple{
        int dist,row,col;
        Tuple(int dist,int row,int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)1e9;
            }
        }
        Queue<Tuple> q=new LinkedList<>();
        dist[0][0]=0;
        q.add(new Tuple(0,0,0)); //source node
        int[] dRow={-1,-1,0,1,1,1,0,-1};
        int[] dCol={0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty()){
            int dis=q.peek().dist;
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();
            //traverse all its 8 neighbours
            for(int i=0;i<8;i++){
                int x=row+dRow[i];
                int y=col+dCol[i];
                if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==0 && (dis+1<dist[x][y])){
                    dist[x][y]=dis+1;
                    if(x==n-1 && y==n-1) return dis+1;
                    q.add(new Tuple(dis+1,x,y));
                }
            }
        }
        return -1;
    }
}
