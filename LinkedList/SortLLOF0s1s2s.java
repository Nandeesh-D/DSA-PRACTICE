package LinkedList;

public class SortLLOF0s1s2s {
    static Node segregate(Node head) {
        // add your code here
        Node zeroHead=new Node(-1);
        Node oneHead=new Node(-1);
        Node twoHead=new Node(-1);
        Node temp=head;
        Node zero=zeroHead,one=oneHead,two=twoHead;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
            }
            else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }

        zero.next=oneHead.next==null?twoHead.next:oneHead.next;
        one.next=twoHead.next;
        two.next=null;
        return zeroHead.next;
    }
}
