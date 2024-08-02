package LinkedList;


//defining node structure
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }

    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
}
public class SingleLLIntro {
    public static void main(String[] args) {

    }

    //converting array to linked list
    public Node convertArrToLL(int[] arr){
        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            temp.next=new Node(arr[i]);
            temp=temp.next;
        }
        return head;
    }

    //traversing through the linked list
    public static void traverse(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ---> ");
            temp=temp.next;
        }
    }

    //method to find the length of linked list
    public static int lengthOfLL(Node head){
        int len=0;
        Node temp=head;
        while(temp!=null){
            len+=1;
            temp=temp.next;
        }
        return len;
    }


    //method to search for an element in ll
    public static boolean consistsOf(Node head,int target) {
        Node temp = head;
        while (head != null) {
            if (head.data == target) return true;
            head = head.next;
        }
        return false;
    }
}
