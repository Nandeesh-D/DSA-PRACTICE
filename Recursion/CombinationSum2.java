package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void combinations(int ind, int[] arr, int t, List<List<Integer>> ans, List<Integer> inner){
        if(t==0) {
            //adds a copy on inner list to ans when if meets this conditions;
            ans.add(new ArrayList<>(inner));
            return;
        }
        //take case will be done only if target<=current element
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(t>=arr[i]){
                inner.add(arr[i]);
                combinations(i+1,arr,t-arr[i],ans,inner);
                inner.remove(inner.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
