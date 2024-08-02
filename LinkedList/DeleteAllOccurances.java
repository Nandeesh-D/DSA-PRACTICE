package LinkedList;

public class DeleteAllOccurances {

    static Node2 deleteAllOccurOfX(Node2 head, int x) {
        // Write your code here

        if(head==null) return null;

        //in case of head is to be deleted
        while(head!=null && head.data==x){
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
        }
        Node2 temp=head;

        while(temp!=null){
            if(temp.data==x){
                Node2 nextNode=temp.next;
                if(temp.prev!=null) temp.prev.next=nextNode;
                if(nextNode!=null) nextNode.prev=temp.prev;
                temp=nextNode;
            }
           else{
               temp=temp.next;
            }
        }
        return head;
    }
}
