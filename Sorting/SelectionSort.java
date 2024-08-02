package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums={3,9,0,2,5,1};
        selection_sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selection_sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int min=i;
            for(int j=i;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            Swap.swap(nums,min,i);
        }
    }
}
