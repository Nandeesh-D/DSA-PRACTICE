package Arrays;

public class MaximumSubarraySum {
    //problem:53
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max){
                max=sum;
            }

            if(sum<0) sum=0;  //since we need to maximise the sum so we neglect the negative sum
        }
        return max;
    }



    //printing the subarray with maximum sum
    public void maxSubArray2(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        int start=0;
        int ansStart=-1,ansEnd=-1;
        for(int i=1;i<nums.length;i++){
            if(sum==0) start=i; //track the starting point every new subarray
            sum+=nums[i];
            if(sum>max){
                max=sum;
                ansStart=start;   //start index of new updated max subarray
                ansEnd=i;         //end index of newly updated max subarray
            }

            if(sum<0) sum=0;  //since we need to maximise the sum so we neglect the negative sum
        }

        System.out.println("The max sub array is:");
        for(int i=ansStart;i<=ansEnd;i++){
            System.out.print(nums[i]+" ");
        }

    }
}
