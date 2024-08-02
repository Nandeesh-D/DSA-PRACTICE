package Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={3,0,1,5,7};
        System.out.println(search(arr,7));
    }
    public static int search(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) return i;
        }
        return -1;
    }
}
