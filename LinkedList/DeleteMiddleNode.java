package LinkedList;

public class DeleteMiddleNode {

    public Node deleteMiddle(Node head) {
        if(head==null || head.next==null) return null;
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //now slow is pointing to the middle node
        if(slow.next!=null){
            slow.data=slow.next.data;
            slow.next=slow.next.next;
        }
        else{   //in case of 2 nodes only
            head.next=null;
        }
        return head;
    }
}
