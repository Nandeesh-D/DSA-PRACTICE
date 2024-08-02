package Graphs;

import java.util.LinkedList;
import java.util.Queue;

//problem: 542
public class Matrix_01 {
    class Pair<T,U>{
        T first;
        U second;
        public Pair(T first,U second){
            this.first=first;
            this.second=second;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
       int m=mat.length;
       int n=mat[0].length;
       Queue<Pair<Pair<Integer,Integer>,Integer>> q=new LinkedList<>();
       int[][] vis=new int[m][n];
       int[][] result=new int[m][n];
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(mat[i][j]==0){
                   vis[i][j]=1;
                   q.add(new Pair<>(new Pair<>(i,j),0));
               }else{
                   vis[i][j]=0;
               }
           }
       }

       int dx[] = {0, 0, 1, -1};
       int dy[] = {1, -1, 0, 0};
       while(!q.isEmpty()){
           int row=q.peek().first.first;
           int col=q.peek().first.second;
           int dist=q.peek().second;
           q.poll();
           result[row][col]=dist;



           for(int i=0;i<4;i++){
               int x=row+dx[i];
               int y=col+dy[i];

               if(x>=0 && x<m && y>=0 && y<n && vis[x][y]==0){
                   vis[x][y]=1;
                   q.add(new Pair<>(new Pair<>(x,y),dist+1));
               }
           }
       }
       return result;
    }



}


