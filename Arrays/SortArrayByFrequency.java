package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        Integer[] obj=new Integer[nums.length];
        int i=0;
        for(int num:nums){
            obj[i]=num;
            i++;
        }


        Arrays.sort(obj, (a, b)->{
            if(freq.get(a).equals(freq.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(freq.get(a),freq.get(b));
        });

        for(i=0;i<nums.length;i++){
            nums[i]=obj[i];
        }

        return nums;
    }
}


