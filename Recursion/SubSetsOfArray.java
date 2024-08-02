package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsOfArray {
    public static void main(String[] args) {
        int[] arr={1,2,2};
        for(List<Integer> sub:subsets1(arr)){
            System.out.println(sub);
        }
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> outer=new ArrayList<>();

        outer.add(new ArrayList<>());
        for(int num:nums){
            int n=outer.size();
            for(int i=0;i<n;i++){
                List<Integer> inner=new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

    //array having duplicates
    public static List<List<Integer>> subsets1(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> outer=new ArrayList<>();
        int start=0;
        int end=0;
        outer.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            start=0;
            if(i>0 && nums[i-1]==nums[i]) start=end+1;
            end=outer.size()-1;
            int n=outer.size();
            for(int j=start;j<n;j++){
                List<Integer> inner=new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
