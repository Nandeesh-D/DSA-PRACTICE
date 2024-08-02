package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombinations {
    public static List<String> helper(String p,String up){
        List<String> list=new ArrayList<>();
        if(p.isEmpty() && up.isEmpty()) return list;
        if(up.isEmpty()){
            list.add(p);
            return list;
        }

        int r= up.charAt(0);
        String[] ch=new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<ch[r].length();i++){
            list.addAll(helper(p+ch[r].charAt(i),up.substring(1)));
        }
        return list;
    }
    public List<String> letterCombinations(String digits) {
        return helper("",digits);
    }

}
