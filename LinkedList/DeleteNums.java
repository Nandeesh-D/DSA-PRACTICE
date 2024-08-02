package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DeleteNums {
    public static void main(String[] args) {
        String s="45320";
        System.out.println(sample(s));
    }

//public Node list(Node head,int[] nums){
//    if(head==null) return null;
//
//    Set<Integer> s=new HashSet<>();
//    for(int num:nums){
//        s.add(num);
//    }
//
//    ListNode dummy=new ListNode(0);
//    dummy.next=head;
//
//    ListNode prev=dummy;
//    ListNode curr=head;
//    while(curr!=null){
//        if(s.contains(curr.val)){
//            prev.next=curr.next;
//        }else{
//            prev=curr;
//        }
//        curr=curr.next;
//    }
//    return dummy.next;
//}


    public static String sample(String s){
        StringBuffer str=new StringBuffer(s);
        for(int i=0;i<s.length()-1;i++){
            if(Character.getNumericValue(str.charAt(i))%2== Character.getNumericValue(str.charAt(i+1))%2){
                if(str.charAt(i)>str.charAt(i+1)){
                    char t=str.charAt(i);
                    str.setCharAt(i,str.charAt(i+1));
                    str.setCharAt(i+1,t);
                    break;
                }
            }
        }
        return str.toString();
    }
}
