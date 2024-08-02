package Recursion;

import java.util.ArrayList;

public class SubsequencesAlongWithASCII {
    public static void main(String[] args) {
        System.out.println( subsequences("","ab"));
        System.out.println(Integer.parseInt("9"));
        String s="ab";
        System.out.println(s.substring(1));
    }

    public static ArrayList<String> subsequences(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> l=new ArrayList<>();
            l.add(p);
            return  l;
        }

        char ch= up.charAt(0);
        ArrayList<String> left=subsequences(p,up.substring(1));
        ArrayList<String> right=subsequences(p+ch,up.substring(1));
        ArrayList<String> middle=subsequences(p+(ch+0),up.substring(1));

        left.addAll(right);
        left.addAll(middle);
        return left;
    }


}
