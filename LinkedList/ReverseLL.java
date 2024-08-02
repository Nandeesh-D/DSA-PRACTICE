package LinkedList;

public class ReverseLL {
    public static Node reverseList(Node head) {
            Node prev=null;
            Node temp=head;

            while(temp!=null){
                Node front=temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
            }
            return prev;
    }


    //recursive traversal
    public Node reverseList2(Node head) {
        //if ll is empty or having  only 1 node
        if(head==null || head.next==null){
            return head;
        }

        Node newHead=reverseList2(head.next);

        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
