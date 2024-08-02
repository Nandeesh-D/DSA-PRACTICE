package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfAString {
    public static void main(String[] args) {
        permutations("","abc");
    }

    public static void permutations(String p,String up){
        if(up.length()==0){
            System.out.println(p);
            return;
        }

        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String last=p.substring(i,p.length());
            permutations(first+ch+last,up.substring(1));
        }
    }

    public static List<String> permutations1(String p, String up){
        if(up.length()==0){
            List<String> l=new ArrayList<>();
            l.add(p);
            return l;
        }

        char ch=up.charAt(0);
        List<String> ans=new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String last=p.substring(i,p.length());
            ans.addAll(permutations1(first+ch+last,up.substring(1)));
        }
        return ans;
    }
}
