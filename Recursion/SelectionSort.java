package Recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort s=new SelectionSort();
        int[] arr={4,3,2,1};
        s.selectionSort(arr,arr.length,0,1,0);
        System.out.println(Arrays.toString(arr));
    }
    public void selectionSort(int[] nums,int n,int i,int j,int min){
        if(i>=n-1) return;

        if(j<n){  //finding minimum element
            if(nums[j]<nums[min]){
                selectionSort(nums,n,i,j+1,j);
            }
            else{
                selectionSort(nums,n,i,j+1,min);
            }
        }
        //go to next i value in case of min value is found
        else{
            int t=nums[i];
            nums[i]=nums[min];
            nums[min]=t;
            selectionSort(nums,n,i+1,i+2,i+1);
        }
    }
}
