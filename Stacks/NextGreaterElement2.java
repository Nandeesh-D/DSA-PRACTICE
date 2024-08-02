package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElement(int[] nums) {
        int[] result=new int[nums.length];
        Stack<Integer> st = new Stack<>();
        int n=nums.length;
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }

            int ans=st.isEmpty()?-1:st.peek();
            result[i%n]=ans;
            st.push(nums[i%n]);
        }
        return result;
    }
}
