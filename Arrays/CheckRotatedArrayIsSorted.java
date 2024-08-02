package Arrays;
//problem:1752

//Algo:
/*
1.Initialize Variables: Start by initializing n to the length of the array and count to 0. The variable count will keep track of the number of "drops" we encounter.
2.Count Drops in the Array: Iterate through the array and compare each element with the next one. If an element is greater than the next one, increment count.
3.Check Wrap Around: After the loop, check if the first element is less than the last element. If it is, increment count since this implies a "drop" from the end of the array to the start.
4.Final Check: If count is less than or equal to 1, return true; otherwise, return false. */
public class CheckRotatedArrayIsSorted {

    public boolean check(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]) count++;
        }

        if(nums[0]<nums[n-1]) count++;

        return count<=1;
    }
}
