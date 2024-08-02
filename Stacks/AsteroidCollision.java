package Stacks;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();

        for(int i:asteroids){
            //condition for collision
            while(!s.isEmpty() && i<0 && s.peek()>0){
                int diff=i+s.peek();
                if(diff<0){  //negative asteroid wins and add it to stack
                    s.pop();
                }
                else if(diff>0){ //positive asteroid wins and no need to add again stack bcz it's already in the stack
                    i=0;
                }
                else{  //both will collapse  no need to add to stack and pop the peek element
                    i=0;
                    s.pop();
                }
            }
            if(i!=0) s.push(i);
        }

        int[] ans=new int[s.size()];
        int i=s.size()-1;
        while(!s.isEmpty()){
            ans[i]=s.pop();
            i--;
        }
        return ans;
    }


    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int i : asteroids) {
            if (i > 0) {   //if positive asteroid
                s.push(i);
            } else { // i is negative
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)) {
                    s.pop();
                }
                if (s.isEmpty() || s.peek() < 0) {
                    s.push(i);
                } else if (i + s.peek() == 0) {
                    s.pop(); // equal
                }
            }
        }
        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }

}
