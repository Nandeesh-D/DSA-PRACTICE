package Arrays;
//problem: 26

//given array is sorted in ascending order
public class RemoveDuplicatesInPlace {
    public int removeDuplicates(int[] nums) {
        int cur=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) {
                nums[cur]=nums[i];
                cur++;
            }
        }
        return cur;
    }
}
