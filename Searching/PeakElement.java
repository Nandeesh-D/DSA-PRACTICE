package Searching;
//problem:162
public class PeakElement {
    public int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            //eliminates the right half
            if(nums[mid]>nums[mid+1]) e=mid;
            //eliminates the left half
            else s=mid+1;
        }
        return e;
    }



}
