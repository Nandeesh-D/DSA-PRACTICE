package Searching;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr={7,8,9,1,2,3,4,5,6};
        System.out.println(search(arr,0));
    }
    public static int search(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int m=(s+e)/2;
            if(nums[m]==target){
                return m;
            }

            //identify which half is sorted
            //left sorted
            if(nums[s]<=nums[m]){
                //check for target is in this portion or not
                if(nums[s]<=target && nums[m]>=target){
                    e=m-1; //if target is in this left sorted portion then eliminate the right half
                }else{
                    s=m+1; //otherwise eliminate left half
                }
            }
            //right sorted half
            if(nums[m]<=nums[e]){
                //check for target is in this portion or not
                if(nums[m]<=target && nums[e]>=target){
                    s=m+1; //if target is in this right sorted portion then eliminate the left half
                }else{
                    e=m-1; //otherwise eliminate the right half
                }
            }
        }
        return -1;
    }


    public static boolean search2(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int m=(s+e)/2;
            if(nums[m]==target){
                return true;
            }

            //trimming the search space
            if(nums[s]==nums[m] && nums[m]==nums[e]){
                s=s+1;
                e=e-1;
                continue;
            }

            //identify which half is sorted
            //left sorted
            if(nums[s]<=nums[m]){
                //check for target is in this portion or not
                if(nums[s]<=target && nums[m]>=target){
                    e=m-1; //if target is in this left sorted portion then eliminate the right half
                }else{
                    s=m+1; //otherwise eliminate left half
                }
            }
            //right sorted half
            if(nums[m]<=nums[e]){
                //check for target is in this portion or not
                if(nums[m]<=target && nums[e]>=target){
                    s=m+1; //if target is in this right sorted portion then eliminate the left half
                }else{
                    e=m-1; //otherwise eliminate the right half
                }
            }
        }
        return false;
    }
}
