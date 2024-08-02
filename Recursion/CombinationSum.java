package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    //method that finds all the possible combinations of an int array;
    public static void combinations(int i,int[] arr,int t,List<List<Integer>> ans,List<Integer> inner){
        if(i==arr.length){
            if(t==0){
                //adds a copy on inner list to ans when if meets this conditions;
                ans.add(new ArrayList<>(inner));
            }
            return;
        }
        //take case will be done only if target<=current element
        if(t>=arr[i]){
            inner.add(arr[i]);
            combinations(i,arr,t-arr[i],ans,inner);
            inner.remove(inner.size()-1);
        }
        //not take case
        combinations(i+1,arr,t,ans,inner);
    }
}
