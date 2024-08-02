package Stacks;

import java.util.Stack;

//problem: 1598
public class LogFolder {
    public int minOperations(String[] logs) {
        Stack<String> s=new Stack<>();
        for(String i:logs){
            if(i.equals("../")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else if(i.equals("./")){
                continue;
            }else{
                s.push(i);
            }
        }
        return s.size();
    }
}
