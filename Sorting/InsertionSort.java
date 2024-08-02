package Sorting;
import Sorting.Swap;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums={3,9,0,2,5};
        insertion_sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void insertion_sort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int j=i;
            while(j>0 && nums[j-1]>nums[j]){
                Swap.swap(nums,j-1,j);
                j--;
            }
        }
    }
}
