package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={3,0,6,0,3,1,0,-1};
        quick_sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //after every recursive call all the elements before pivot should be less and after should be great
    public static void quick_sort(int[] nums,int low,int high){
        if(low>=high) return;

        int s=low;
        int e=high;
        int mid=s+(e-s)/2;
        //taking pivot as a middle element
        int pivot=nums[mid];

        while(s<=e){

            while(nums[s]<pivot){
                s++;
            }

            while(nums[e]>pivot){
                e--;
            }

            //condition violated
            if(s<=e){
                Swap.swap(nums,s,e);
                s++;
                e--;
            }
        }
        //now our pivot is at correct position
        quick_sort(nums,low,e);  //e will be pointing to the index before pivot
        quick_sort(nums,s,high);  //s will be pointing to the index after pivot
    }
}
