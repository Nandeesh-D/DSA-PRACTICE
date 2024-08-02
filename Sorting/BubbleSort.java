package Sorting;

import Sorting.Swap;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums={3,9,0,2,5};
        bubble_sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubble_sort(int[] nums){

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    Swap.swap(nums,j,j+1);
                }
            }
        }
    }


}
