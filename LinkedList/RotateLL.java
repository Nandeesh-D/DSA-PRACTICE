package LinkedList;

public class RotateLL {
    public Node rotateRight(Node head, int k) {
        if(head==null || head.next==null) return head;
        int len=1;
        Node temp=head;
        while(temp.next!=null){
            ++len;
            temp=temp.next;
        }

        temp.next=head;
        k=k%len;
        int end=len-k;
        temp=head;
        while(end--!=1){
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
}
