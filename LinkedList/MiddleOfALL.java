package LinkedList;

public class MiddleOfALL {
    public static Node middleNode(Node head) {
            Node slow=head;
            Node fast=head;

            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }

            //now slow is pointing to the middle node
            return slow;
    }
}
