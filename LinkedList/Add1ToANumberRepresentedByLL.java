package LinkedList;


import static LinkedList.ReverseLL.reverseList;

public class Add1ToANumberRepresentedByLL {

    public static Node add1(Node head){
        Node rev1=reverseList(head);
        int carry=1;
        Node temp=rev1;
        Node prev=null;
        while(temp!=null){
            int sum= temp.data+carry;
            temp.data=sum%10;
            carry=sum/10;
            prev=temp;
            temp=temp.next;
        }
        if(carry!=0){
            Node n=new Node(carry);
            prev.next=n;
        }
        Node rev2=reverseList(rev1);
        return rev2;
    }

    //recursive approach
    public static Node add(Node head){
        int carry=helper(head);
        if(carry!=0){
            Node n=new Node(carry);
            n.next=head;
            head=n;
        }
        return head;
    }


    public static int helper(Node head){
        if(head==null ){
            return 1;
        }
        int sum=head.data+helper(head.next);
        head.data=sum%10;
        return sum/10;
    }
}
