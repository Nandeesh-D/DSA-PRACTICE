package Arrays;

import java.util.HashMap;
import java.util.Map;

//problem: 560
public class SubArraysSumEqualToK {

    //optimal solution
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case for an empty subarray

        for (int num : nums) {
            currentSum += num;
            int complement = currentSum - k;
            count += map.getOrDefault(complement, 0);
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }


    //better approach with time complexity O(N*2)
    public int subarraySum2(int[] nums, int k) {
        int count = 0;

        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
