package LinkedList;

public class IntersectionPointInYLL {
    public Node getIntersectionNode(Node headA, Node headB) {
        Node t1=headA;
        Node t2=headB;
        while(t1!=t2){
            t1=t1==null?headB:t1.next;
            t2=t2==null?headA:t2.next;
        }
        return t1;
    }
}
