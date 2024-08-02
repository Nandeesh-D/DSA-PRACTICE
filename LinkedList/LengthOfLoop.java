package LinkedList;

public class LengthOfLoop {

    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        int len=0;
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=slow.next;
                len=1;
                while(slow!=fast){
                    len++;
                    slow=slow.next;
                }
                return len;
            }

        }
        return len;
    }
}
