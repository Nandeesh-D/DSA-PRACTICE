package Searching;

public class MinElementInRotatedSortedArray {
    public int findMin(int[] arr) {
        int s=0;
        int e=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(s<=e){
            int m=(s+e)/2;
            //if whole array is sorted
            if (arr[s] <= arr[e]) {
                ans = Math.min(ans, arr[s]);
                break;
            }

            //left half is sorted
            if(arr[s]<=arr[m]){
                ans=Math.min(ans,arr[s]);
                s=m+1;
            }

            //right half
            else{
                ans=Math.min(ans,arr[m]);
                e=m-1;
            }
        }
        return ans;
    }
}
