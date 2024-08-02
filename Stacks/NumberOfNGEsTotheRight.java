package Stacks;

import java.util.Stack;

public class NumberOfNGEsTotheRight {

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        // code here
        int[] result=new int[indices.length];
        Stack<Integer> st=new Stack<>();
        int j=queries-1;
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }

            int ans=st.isEmpty()?0:st.size();
            if(i==j){
                result[j]=ans;
                j--;
            }
            st.push(arr[i]);
        }

        return result;

    }
}
