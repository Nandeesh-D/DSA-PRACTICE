package Recursion;

public class SortedArrayOrNot {
    public static void main(String[] args) {
        SortedArrayOrNot s=new SortedArrayOrNot();
        int[] arr={4,1,2,3,4,5};
        System.out.println(s.sorted(arr));
    }

    public boolean sorted(int[] nums){
        return helper(nums,1);
    }

    private boolean helper(int[] nums,int i){
        if(i==nums.length) return true;
        return nums[i-1]<nums[i] && helper(nums,i+1);
    }
}
