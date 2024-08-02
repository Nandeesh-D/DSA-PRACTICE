package Sorting;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] nums={3,4,1,2,5};
        cyclic_sort1(nums);
        System.out.println(Arrays.toString(nums));
    }
    //sorting array with numbers ranging from 1 to 100
    public static void cyclic_sort1(int[] nums){
            int i=0;
            while(i<nums.length){
                int correct_index=nums[i]-1;
                if( nums[i]!=nums[correct_index]){
                    Swap.swap(nums,i,correct_index);
                }else{
                    i++;
                }
            }
    }

    //problem:268
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct_index=nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct_index]){
                Swap.swap(nums,i,correct_index);
            }else{
                i++;
            }
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i) return i;
        }
        return nums.length;
    }


    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct_index=nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct_index]){
                Swap.swap(nums,i,correct_index);
            }else{
                i++;
            }
        }
        return nums[nums.length-1];
    }

    //problem:41
    //Find first missing positive number from the array containing negatives,zero,positives
    //Ex:[3,4,-1,1]
    //output: 2
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct_index=nums[i]-1;
            if(nums[i]>0 && nums[i]<nums.length && nums[i]!=nums[correct_index]){
                Swap.swap(nums,i,correct_index);
            }else{
                i++;
            }
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
}
