package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }

            int ans=st.isEmpty()?-1:st.peek();
            map.put(nums2[i],ans);
            st.push(nums2[i]);
    }
        int[] result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i]=map.get(nums1[i]);
        }

        return result;
}
}
