package LinkedList;

import java.util.Scanner;

public class DoubleLLIntro {

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        Node2 head=convertToDLL(arr);
        int position;
        System.out.println("Enter the position of node you want to delete: ");
        Scanner sc=new Scanner(System.in);
        position=sc.nextInt();
        //Node2 new_head=deletePosition(head,position);
        Node2 b=insertBeg(head,10);
        Node2 l=insertEnd(b,20);
        Node2 k=insertPos(l,45,1);
        traverse(k);
    }

    //converting array to doubly linked list
    public static Node2 convertToDLL(int[] arr){
        Node2 head =new Node2(arr[0]);
        Node2 prev=head;

        for(int i=1;i<arr.length;i++){
            Node2 temp=new Node2(arr[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }

    //traversing through doubly linked list
    public static void traverse(Node2 head){
        Node2 temp=head;
        while(temp!=null){
            System.out.print(temp.data+" <---> ");
            temp=temp.next;
        }
    }

    //deleting the head fo a dll
    public static Node2 deleteHead(Node2 head){
        //if list have no or 1 element
        Node2 prev=head;
        if(head==null || head.next==null) return null;
        head=head.next;
        head.prev=null;
        prev.next=null;
        return head;
    }

    //deleting the tail of dll
    public static Node2 deleteTail(Node2 head){
        Node2 temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next.prev=null;
        temp.next=null;
        return head;
    }
    //deleting node at kth position
    public static Node2 deletePosition(Node2 head,int k){
        Node2 temp=head;
        int cnt=0;
        while(temp.next!=null){
            cnt++;
            if(cnt==k){
                break;
            }
            temp=temp.next;
        }
        //to get prev node
        Node2 prev=temp.prev;
        //to get next node
        Node2 next=temp.next;
        //if there is no or 1 element in ll
        if(prev==null && next==null){
            return null;
        }
        //if the case is deleting the tail
        else if (next==null) {
            return deleteTail(temp);
        }
        //if the case is deleting the head
        else if(prev==null){
            return deleteHead(temp);
        }
        //if the case is deleting a pos k
        prev.next=next;
        next.prev=prev;
        temp.prev=null;
        temp.next=null;
        return head;
    }

    //Insertion at the beginning
    public static Node2 insertBeg(Node2 head,int element){
        Node2 temp=new Node2(element,head,null);
        head.prev=temp;
        head=temp;
        return head;
    }

    //Insertion at the end
    public static Node2 insertEnd(Node2 head,int element){
        Node2 temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node2 new_node=new Node2(element,null,temp);
        temp.next=new_node;
        return head;
    }

    //Insertion before position k
    public static Node2 insertPos(Node2 head,int element,int k){
        if(k==1) return insertBeg(head,element);
        int cnt=0;
        Node2 temp=head;
        while(temp.next!=null){
            cnt++;
            if(cnt==k) break;
            temp=temp.next;
        }
        Node2 prev=temp.prev;
        Node2 new_node=new Node2(element,temp,prev);
        prev.next=new_node;
        temp.prev=new_node;
        return head;
    }
}


class Node2{
    int data;
    Node2 next;
    Node2 prev;

    Node2(int data,Node2 next,Node2 prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }

    Node2(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

