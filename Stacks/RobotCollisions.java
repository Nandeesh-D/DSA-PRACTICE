package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
           int n=positions.length;
           Integer[] indices=new Integer[n];
           List<Integer> result=new ArrayList<>();
           Stack<Integer> s=new Stack<>();

           for(int i=0;i<n;i++){
               indices[i]=i;
           }

           Arrays.sort(indices,(l,r)->Integer.compare(positions[l],positions[r]));

           for(Integer currIndex:indices){
               if(directions.charAt(currIndex)=='R'){
                   s.push(currIndex);
               }else{
                   while (!s.isEmpty() && healths[currIndex] > 0) {
                       // Pop the top robot from the stack for collision check
                       int topIndex = s.pop();

                       // Top robot survives, current robot is destroyed
                       if (healths[topIndex] > healths[currIndex]) {
                           healths[topIndex] -= 1;
                           healths[currIndex] = 0;
                           s.push(topIndex);
                       } else if (healths[topIndex] < healths[currIndex]) {
                           // Current robot survives, top robot is destroyed
                           healths[currIndex] -= 1;
                           healths[topIndex] = 0;
                       } else {
                           // Both robots are destroyed
                           healths[currIndex] = 0;
                           healths[topIndex] = 0;
                       }
                   }
               }
           }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}
