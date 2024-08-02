package LinkedList;

public class InsertionSortOfLL {
    public Node insertionSortList(Node head) {
        Node temp;
        for(temp=head;temp.next!=null;temp=temp.next){
            Node j=head;
            while(j!=temp && j.data>j.next.data){
                int t=j.data;
                j.data=j.next.data;
                j.next.data=t;
                j=j.next;
            }
        }
        return head;
    }
}
