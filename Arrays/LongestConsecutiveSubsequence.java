package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//problem: 128
public class LongestConsecutiveSubsequence {

    //optimal approach with time complexity O(N)
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int longest=1; //to store the length of the longest subsequence
        Set<Integer> set=new HashSet<>();

        //adding all elements into a set
        for(int i:nums){
            set.add(i);
        }

        for(int i:set){
            if(!set.contains(i-1)){ //if the element is starting element of the sequence
                int cnt=1;
                int x=i;
                while(set.contains(x+1)){  //finding next element in the sequence is in the list or not
                    x=x+1;
                    cnt++;
                }
                longest= Math.max(longest,cnt);
            }
        }
        return longest;
    }


    //better solution with time complexity O(NlogN) + O(N)
    public int longestConsecutive2(int[] nums) {
        int longest=1; //to store the length of the longest subsequence
        Arrays.sort(nums);
        int cnt=1;
        int lastSmaller=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==lastSmaller){
                cnt+=1;
                lastSmaller=nums[i];
            }else if(lastSmaller!=nums[i]){  //if unmatched element of sequence is found
                cnt=1;
                lastSmaller=nums[i];
            }

            longest=Math.max(cnt,longest);
        }
        return longest;
    }
}
