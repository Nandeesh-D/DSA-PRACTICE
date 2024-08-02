package Arrays;

public class ZeroSumSubarrays {
    public static long findSubarray(long[] arr ,int n)
    {
        //Your code here
        int cnt=0;
        for(int i=0;i<n;i++){
            long s=0;
            for(int j=i;j<n;j++){
                s+=arr[i];

                if(s==0){
                    cnt+=1;
                    break;
                }
            }
        }
        return cnt;
    }
}
