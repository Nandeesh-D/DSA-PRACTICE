package Arrays;

import java.util.Arrays;

public class SortTheJumbledNumbers {
    public static void main(String[] args) {
        int[] mapping={8,9,4,0,2,1,3,5,7,6};
        int[] nums={991,338,38};
        System.out.println(Arrays.toString(sortJumbled(mapping,nums)));
    }
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 0) {
                temp[i] = mapping[0];
                continue;
            }

            long mapped = 0;
            long place = 1;

            while (num > 0) {
                int digit = num % 10;
                mapped += (long)mapping[digit] * place;
                place *= 10;
                num /= 10;
            }

            temp[i] = (int)mapped;
        }

        Integer[] indices=new Integer[n];
        for(int i=0;i<n;i++){
            indices[i]=i;
        }

        Arrays.sort(indices,(a,b)-> Integer.compare(temp[a],temp[b]));

        for(int i=0;i<n;i++){
            temp[i]=nums[indices[i]];
        }
        return temp;
    }



}
