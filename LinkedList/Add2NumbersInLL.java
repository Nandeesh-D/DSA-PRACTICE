package LinkedList;

public class Add2NumbersInLL {
    public static Node addLL(Node head1,Node head2){
        Node t1=head1; //pointing to 1st ll
        Node t2=head2; //pointing to 2nd ll
        Node dummy=new Node(-1);  //to make code simple
        Node current=dummy; //to point the current node in resultant ll
        int carry=0; //to store carriage value
        while(t1!=null || t2!=null){   //run until both of them become null
            int sum=carry;        //to store sum of 2 nodes
            if(t1!=null) sum+=t1.data;  //if t1 is not empty
            if(t2!=null) sum+=t2.data; //if t2 is not empty

            Node res=new Node(sum%10);  //creating new node with the last digit in sum
            carry=sum/10;  //carriage becomes sum/10
            current.next=res;
            current=current.next;
            if(t1!=null) t1=t1.next;
            if(t2!=null) t2=t2.next;
        }
        if(carry!=0){  //if carry remains after all nodes in both ll's are completed
            Node res=new Node(carry);
            current.next=res;
        }
        return dummy.next;  //dummy.next will be the head of the resultant ll
    }
}
