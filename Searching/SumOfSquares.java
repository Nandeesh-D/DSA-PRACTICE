package Searching;
//problem: 633
public class SumOfSquares {
    public boolean judgeSquareSum(int c) {
        for(long a=0;a*a<=c;a++){
            int want=c-(int) (a*a);
            if(binary_search(0,want,want)){
                return true;
            }
        }
        return false;
    }

    public boolean binary_search(long s,long e,int target){
        if(s>e) return false;
        long mid=s+(e-s)/2;
        if(mid*mid==target) return true;
        if(mid*mid>target) return binary_search(s,mid-1,target);
        return binary_search(mid+1,e,target);
    }


    //approach2
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {   // Iterate through all possible values of `a`
            double b = Math.sqrt(c - a * a);  // Compute `b` as the square root of `c - a^2`
            if (b == (int)b) {                 // Check if `b` is an integer
                return true;                   // If `b` is an integer, return true
            }
        }
        return false;                          // If no such pair `(a, b)` is found, return false
    }
}
