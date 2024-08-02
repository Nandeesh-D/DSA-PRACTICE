package Searching;

public class RowWithMAx1s {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int max=-1;
        int cnt_max=0;
        for(int i=0;i<n;i++){
            int cnt_ones=m-lowerBound(arr[i],1);
            if(cnt_ones>cnt_max) {
                max=i;
                cnt_max=cnt_ones;
            }
        }
        return max;
    }

    //function that returns the lower bound of 1
    int lowerBound(int[] arr,int x){
        int s=0;
        int e=arr.length;

        while(s<=e){
            int m=s+(e-s)/2;
            if(arr[m]==1) e=m-1;
            else s=m+1;
        }
        return  s;
    }
}
