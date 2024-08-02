package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums={1,3,5,6,7,8,9};
        System.out.println();
        BinarySearch b=new BinarySearch();
        System.out.println(b.binarySearch(nums,10));
    }
    public int binarySearch(int[] nums,int target){
         return helper(nums,0,nums.length-1,target);
    }

    private int helper(int[] nums,int s,int e,int target){
        if(s>e) return -1;

        int mid=(s+e)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]>target){
            return helper(nums,s,mid-1,target);
        }
        return helper(nums,mid+1,e,target);
    }
}
