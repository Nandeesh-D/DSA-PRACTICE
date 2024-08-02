package Stacks;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            //if the current incoming character is open brace then push it to stack
            if(cur=='(' || cur=='[' || cur=='{') st.push(cur);
            else{
                if(st.isEmpty()) return false;
                char ch=st.pop();
                if(cur==')' && ch=='(' || cur==']' && ch=='[' || cur=='}' && ch=='{') continue;
                else return false;
            }
        }
        return st.isEmpty(); //if stack empty means string matched perfectly otherwise it is invalid
    }
}
