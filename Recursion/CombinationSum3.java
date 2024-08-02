package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        if(n<k)  return ans;
        combinations(1,k,n,n,ans,new ArrayList<>());
        return ans;
    }

    public static void combinations(int ind,int k,int n,int t, List<List<Integer>> ans, List<Integer> inner){
        if(t==0) {
            //adds a copy on inner list to ans when if meets this conditions;
            if(inner.size()==k){
                ans.add(new ArrayList<>(inner));
            }
            return;
        }
        //take case will be done only if target<=current element
        for(int i=ind;i<n+1;i++){
            if(t>=i){
                inner.add(i);
                combinations(i+1,k,n,t-i,ans,inner);
                inner.remove(inner.size()-1);
            }else break;
        }
    }
}
