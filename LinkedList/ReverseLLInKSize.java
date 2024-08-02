package LinkedList;
import LinkedList.ReverseLL;
public class ReverseLLInKSize {
    ReverseLL r=new ReverseLL();
    public Node reverseKGroup(Node head, int k) {
        Node temp=head;
        Node prevLast=null;
        while(temp!=null){
            Node KthNode=getKthNode(temp,k);

            //not a complete group of k nodes
            if(KthNode==null){

                if(prevLast!=null){
                    prevLast.next=temp;
                }
                break;
            }

            Node nextNode=KthNode.next;
            KthNode.next=null;
            r.reverseList(temp);

            if(head==temp){
                head=KthNode;
            }else{
                prevLast.next=KthNode;
            }

            prevLast=temp;
            temp=nextNode;

        }
        return head;
    }

    public Node getKthNode(Node head,int k){
        Node temp=head;
        k-=1;
        while(temp!=null && k>0){
            temp=temp.next;
            k--;
        }
        return temp;
    }
}
