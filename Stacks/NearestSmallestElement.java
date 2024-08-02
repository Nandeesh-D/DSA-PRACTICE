package Stacks;

import java.util.Stack;

public class NearestSmallestElement {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] result=new int[A.length];
        int n=A.length;
        for(int i=0;i<n;i++){
            //first pop all the elements >= current element
            while(!st.isEmpty() && st.peek()>=A[i]){
                st.pop();
            }

            int ans= st.isEmpty()?-1:st.peek();
            result[i]=ans;
            st.push(A[i]);
        }
        return result;
    }
}
