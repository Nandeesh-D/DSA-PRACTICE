package LinkedList;

import java.util.ArrayList;

public class FindPairsWithGivenSum {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node2 head) {
        // code here
        if(head==null || head.next==null) return null;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Node2 left=head;
        Node2 right=head;
        while(right.next!=null){
            right=right.next;
        }

        while(right.data>left.data){
            int sum=left.data+right.data;
            if(sum==target){
                ArrayList<Integer> pair=new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                ans.add(pair);
                left = left.next;
                right = right.prev;
            }
            else if(sum>target){
                right=right.prev;
            }else{
                left=left.next;
            }
        }
        return ans;
    }
}
