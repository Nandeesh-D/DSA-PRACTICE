package LinkedList;

public class SegregateOddEvenNodes {

    public Node oddEvenList(Node head) {
        if(head==null || head.next==null) return head;
        Node odd=head;  //to point odd Nodes
        Node even=head.next; //to point even Nodes
        Node evenHead=head.next;

        while(even!=null && even.next!=null){ //why this condition because if even can't reach end then automatically odd also can't reach the end
            odd.next=odd.next.next;      //linking all odd Nodes
            even.next=even.next.next;  //linking all even Nodes

            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;  //linking last odd Node  with first Node of even Nodes ll
        return head;

    }
}
