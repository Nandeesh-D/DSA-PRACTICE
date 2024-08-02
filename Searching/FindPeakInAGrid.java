package Searching;
//problem: 1901
public class FindPeakInAGrid {
    public int[] findPeakGrid(int[][] mat) {
           int low=0;
           int high= mat[0].length-1;

           while(low<=high){
               int mid=(low+high)/2;
               int row=maxElement(mat,mid); //this eliminates the 2 cases of peak element i.e. top and bottom
               //now we need to compare left and right elements with current element to be peak element
               int left=mid-1>=0?mat[row][mid-1]:-1;
               int right=mid+1<mat[0].length?mat[row][mid+1]:-1;

               if(mat[row][mid]>left && mat[row][mid]>right) return new int[]{row,mid};
               else if(mat[row][mid]<left) high=mid-1;  //if peak element is in left side of current element
               else low=mid+1;
           }
           return new int[]{-1,-1};
    }

    //function that returns row number of a max element in the given column
    //this eliminates the 2 cases of peak element i.e. top and bottom
    int maxElement(int[][] arr,int col){
        int max=-1;
        int index=-1;
        for(int row=0;row<arr.length;row++){
            if(arr[row][col]>max){
                max=arr[row][col];
                index=row;
            }
        }
        return index;
    }
}
