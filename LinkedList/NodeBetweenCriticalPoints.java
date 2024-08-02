package LinkedList;

import java.util.ArrayList;

public class NodeBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(Node head) {
        ArrayList<Integer> points=new ArrayList<>();
        int[] ans={-1,-1};
        if(head==null || head.next==null|| head.next.next==null) return ans;
        Node prev=head;
        Node curr=head.next;
        Node front=head.next.next;
        int count=2;  //to count the index of nodes
        while(front!=null){
            //local maxima
            if(curr.data>prev.data && curr.data>front.data) points.add(count);
            //local minima
            if(curr.data<prev.data && curr.data<front.data) points.add(count);
            count+=1;

            prev=curr;
            curr=front;
            front=front.next;
        }
        int s=points.size();
        if(s<2) return ans;
        ans[1]=points.get(s-1)-points.get(0);
        int min = Integer.MAX_VALUE;
        for(int i=1; i<s; i++){
            min = Math.min(points.get(i)-points.get(i-1),min);
        }
        ans[0] = min;
        return ans;
    }
}
