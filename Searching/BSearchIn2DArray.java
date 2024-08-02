package Searching;
//problem:74
public class BSearchIn2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
            int low=0;
            int high= matrix.length*matrix[0].length-1;

            while(low<=high){
                int mid=(low+high)/2;
                int row=mid/matrix[0].length;
                int col=mid%matrix[0].length;

                if(matrix[row][col]==target) return true;
                else if (matrix[row][col]<target) {
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            return false;
    }


    //problem:240
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target) return true;
            else if (matrix[row][col]<target) {
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
