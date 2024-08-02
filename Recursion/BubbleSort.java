package Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort b=new BubbleSort();
        int[] arr={4,3,2,1,6,0};
        b.bubbleSort(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
    public  void bubbleSort(int[] nums,int n,int i,int j){
        if(i>=n-1) return;

        if(j<n-i-1){
            if(nums[j]>nums[j+1]){
                int t=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=t;
            }
            bubbleSort(nums,n,i,j+1);
        }
        bubbleSort(nums,n,i+1,0);
    }
}
