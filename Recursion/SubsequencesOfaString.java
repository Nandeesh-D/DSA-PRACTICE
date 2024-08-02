package Recursion;

import java.util.ArrayList;

public class SubsequencesOfaString {
    public static void main(String[] args) {
        String s="abc";
        subsequences(s);
    }

    public static void subsequences(String up){
        System.out.println( helper("",up));
    }

    public static ArrayList<String> helper(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> l=new ArrayList<>();
            l.add(p);
            return l;
        }

        char ch=up.charAt(0);
        ArrayList<String> left=helper(p+ch,up.substring(1));
        ArrayList<String> right=helper(p,up.substring(1));

        left.addAll(right);
        return left;

    }
}
