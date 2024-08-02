package Stacks;

import java.util.Stack;

public class RemoveKDigits {


    //Whether the current digit is deleted or not depends on the next character to it
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {    //delete the greater elements which are left side of current char in given string
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Remove remaining k digits from the end of the stack because they are in increasing order
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Construct the resulting string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse(); // Reverse to get the correct order

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Handle edge case where result might be empty
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
