package LinkedList;

public class RemoveNthNodeFromEnd {
    public Node removeNthFromEnd(Node head, int n) {
             Node fast=head;
             while(n>0){
                 fast=fast.next;
                 n--;
             }

             if(fast==null){
                 return head.next;
             }

             Node slow=head;
             while(fast.next!=null){
                 slow=slow.next;
                 fast=fast.next;
             }
             //slow.next is the node to be deleted
             slow.next=slow.next.next;
             return head;
    }
}
