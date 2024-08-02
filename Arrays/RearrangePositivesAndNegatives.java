package Arrays;


//problem:2149


import java.util.Arrays;

public class RearrangePositivesAndNegatives {
    public static void main(String[] args) {
        int[] arr={1,2,-1,-1};
        int[] ans=rearrangeArray(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] rearrangeArray(int[] nums) {
        int p=0;   //pointing to positive index
        int n=1;    //pointing to negative index
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[p]=nums[i];
                p+=2;
            }else{
                ans[n]=nums[i];
                n+=2;
            }
        }
       return ans;
    }


}

