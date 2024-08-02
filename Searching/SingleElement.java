package Searching;

//problem:540
public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;

       if(n==1) return nums[0];
       //edge cases
       if (nums[0]!=nums[1]) return nums[0];
       if(nums[n-1]!=nums[n-2]) return nums[n-1];

       //search space is reduced due to above edge cases
       int s=1;
       int e=n-2;
       while(s<=e){
           int mid=s+(e-s)/2;
           //In case of answer
           if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];

           //eliminates the left half
           if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])){
               s=mid+1;
           }
           //eliminates the right half
           else{
               e=mid-1;
           }

       }
       return -1;
    }
}
