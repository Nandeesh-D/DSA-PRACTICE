package Searching;
//problem:1539
public class KthMissingPositiveInteger {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int m=(low+high)/2;
            int missing=arr[m]-(m+1);
            if(missing<k){
                low=m+1;
            }else{
                high=m-1;
            }
        }
        return k+high+1;
    }
}
