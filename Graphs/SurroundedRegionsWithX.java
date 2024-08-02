package Graphs;

import java.util.Arrays;

//problem:130
public class SurroundedRegionsWithX {
    public static void main(String[] args) {
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };
        solve(board);
        for(char[] n:board){
            System.out.println(Arrays.toString(n));
        }

    }
    public static void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        int[][] vis=new int[m][n];
        //for first and last row O's
        for(int i=0;i<n;i++){
            //first row
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(0,i,vis,board,dRow,dCol);
            }
            //last row
            if(vis[m-1][i]==0 && board[m-1][i]=='O'){
                dfs(m-1,i,vis,board,dRow,dCol);
            }
        }

        //for first and last col O's
        for(int i=0;i<m;i++){
            //for first col
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,vis,board,dRow,dCol);
            }

            //for last col
            if(vis[i][n-1]==0 && board[i][n-1]=='O'){
                dfs(i,n-1,vis,board,dRow,dCol);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }


    public static void dfs(int r,int c,int[][] vis,char[][] board,int[] dRow,int[] dCol){
        vis[r][c]=1;

        //visit the neighbouring nodes
        for(int i=0;i<4;i++){
            int x=r+dRow[i];
            int y=c+dCol[i];

            //if valid neighbour then apply dfs on that
            if(x>=0 && x<board.length && y>=0 && y<board[0].length && vis[x][y]==0 && board[x][y]=='O'){
                dfs(x,y,vis,board,dRow,dCol);
            }
        }
    }


}
