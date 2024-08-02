package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//problem:1019
public class NextGreaterNodes {
    public int[] nextLargerNodes(Node head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.data);
            head = head.next;
        }

        int n = values.size();
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
                answer[stack.peek()] = values.get(i);
                stack.pop();
            }
            stack.add(i);
        }
        return answer;
    }
}
