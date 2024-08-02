package Arrays;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {

    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxi=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                maxi=i+1;   //because prefix sum till now
            }

            if(map.containsKey(sum)){
                maxi=Math.max(maxi,i-map.get(sum)); 
            }
            else map.put(sum,i);
        }
        return maxi;
    }
}
