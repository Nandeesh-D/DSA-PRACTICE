package Recursion;

import BinarySearchTree.InorderPredecessor;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchOnMultipleOccurrances {
    public List<Integer> search(int[] nums,int target){
        return helper(nums,target,0);
    }

    private List<Integer> helper(int[] nums,int target,int index){
        List<Integer> list=new ArrayList<>();
        if(index==nums.length) return list;

        if(nums[index]==target) list.add(index);
        List<Integer> ansFromBelowCalls=helper(nums,target,index+1);
        list.addAll(ansFromBelowCalls);
        return list;

    }
}
