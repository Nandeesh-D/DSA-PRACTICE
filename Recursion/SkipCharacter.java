package Recursion;

public class SkipCharacter {
    public static void main(String[] args) {
        System.out.println(skipChar("","abbabc"));
        System.out.println(skipWord("","bapplecd"));
    }

    public static String skipChar(String p,String up){
        if(up.isEmpty()) return p;

        char ch=up.charAt(0);
        if(ch=='a') return skipChar(p,up.substring(1));
        return skipChar(p+ch,up.substring(1));
    }

    public static String skipWord(String p,String up){
        if(up.isEmpty()) return p;

        if(up.startsWith("apple")) return skipWord(p,up.substring(5));
        return skipWord(p+up.charAt(0),up.substring(1));
    }
}
