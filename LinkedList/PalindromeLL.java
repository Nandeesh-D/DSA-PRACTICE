package LinkedList;


import static LinkedList.ReverseLL.reverseList;

public class PalindromeLL {
    public boolean isPalindrome(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node first=head;
        Node second=reverseList(slow.next);
        slow.next=null;
        while(second!=null){
            if(first.data!=second.data) return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }
}
