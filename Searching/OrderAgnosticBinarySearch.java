package Searching;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr={3,2,0};
        System.out.println(orderAgnosticBinarySearch(arr,3));
    }
    //It is applied when an array is sorted in either increasing or decreasing order but we don't know exactly
    static int orderAgnosticBinarySearch(int[] arr,int target){
        int s=0;
        int e=arr.length-1;

        //to know whether array is sorted in ascending or descending
        boolean isAsc=true;
        if(arr[s]>arr[e]) isAsc=false;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==target) return mid;

            //for ascending ordered arrays
            if(isAsc){
                if(arr[mid]<target) s=mid+1;
                else e=mid-1;
            }
            else{ //for descending ordered arrays
                if(arr[mid]>target) s=mid+1;
                else e=mid-1;
            }
        }
        return -1;
    }
}
