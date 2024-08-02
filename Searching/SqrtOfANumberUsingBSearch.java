package Searching;

public class SqrtOfANumberUsingBSearch {
    long floorSqrt(long x)
    {
        // Your code here
        long low=1,high=x;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(mid*mid<= x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }


    long floorSqrt1(long x)
    {
        // Your code here
        long low=1,high=x;
        long ans=1;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(mid*mid<= x){
                ans=low;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
