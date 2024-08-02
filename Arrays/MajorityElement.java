package Arrays;

import java.util.ArrayList;
import java.util.List;

//problem:169
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int ele=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                cnt=1;
                ele=nums[i];
            }else if(nums[i]==ele) cnt++;
            else cnt--;
        }

        //finally we tracked an element
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele){
                count++;
            }
        }

        if(count>nums.length/2) return ele;  //in case of majority element
        return -1;  //no majority element found
    }


    //problem:229

    //Extended moore's voting algorithm
    //there will be at most 2 elements of frequency > n/3
    public List<Integer> majorityElement2(int[] nums) {

        int cnt1=0,cnt2=0;
        int ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && ele2!=nums[i]){
                cnt1=1;
                ele1=nums[i];
            }else if(cnt2==0 && ele1!=nums[i]){
                cnt2=1;
                ele2=nums[i];
            }
            else if(nums[i]==ele1) cnt1++;
            else if(nums[i]==ele2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1=0;cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                cnt1++;
            }
            if(nums[i]==ele2){
                cnt2++;
            }
        }

        List<Integer> ans=new ArrayList<>();
        if(cnt1>nums.length/3) ans.add(ele1);
        if(cnt2>nums.length/3) ans.add(ele2);

        return ans;
    }
}
