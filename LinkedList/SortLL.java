package LinkedList;

import static LinkedList.MiddleOfALL.middleNode;

public class SortLL {
    public Node sortList(Node head) {
        return sortList(head);
    }

    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }

        //to find mid node
        Node mid=middleNode(head);
        Node left=head;
        Node right=mid.next;
        mid.next=null;
        left=mergeSort(left);
        right=mergeSort(right);

        return merge(left,right);
    }

    private Node merge(Node left, Node right) {
        Node res=new Node(-1);
        Node temp=res;
        while(left!=null && right!=null){
            if(left.data<right.data){
                Node n=new Node(left.data);
                temp.next=n;
                left=left.next;
            }
            else{
                Node n=new Node(right.data);
                temp.next=n;
                right=right.next;
            }
            temp=temp.next;
        }

        while(left!=null){
            temp.next=left;
        }

        while(right!=null){
            temp.next=right;
        }

        return res.next;
    }
}
