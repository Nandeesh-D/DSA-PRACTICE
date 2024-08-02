package LinkedList;

public class RemoveDuplicates {
    Node2 removeDuplicates(Node2 head){
        // Code Here.
        Node2 prevNode=head;
        Node2 cur=head;
        while(cur!=null){

            while(cur.data==prevNode.data){ //move until the node with different value is found
                cur=cur.next;
            }

            prevNode.next=cur;
            cur.prev=prevNode;
            prevNode=cur;
            cur=cur.next;
        }
        return head;
    }
}
