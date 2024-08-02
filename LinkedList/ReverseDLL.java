package LinkedList;

public class ReverseDLL {
    public static Node2 reverseDLL(Node2 head)
    {
        //Your code here
        if(head==null || head.next==null) return head;
        Node2 prev=null;
        Node2 current=head;
        while(current!=null){
            prev=current.prev;
            current.prev=current.next;
            current.next=prev;
            current=current.prev;
        }
        return prev.prev;
    }
}
