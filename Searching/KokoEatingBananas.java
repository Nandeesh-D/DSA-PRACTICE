package Searching;
//problem:875
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findMax(piles);
        int ans=high;
        while(low<=high){
            int m=(low+high)/2;
            int time_taken=timeInHours(piles,m);
            if(time_taken<=h){
                ans=Math.min(ans,m);
                high=m-1;
            }else{
                low=m+1;
            }
        }
        return ans;
    }

    public static int findMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max=Math.max(arr[i],max);
        }
        return max;
    }

    public static int timeInHours(int[] arr,int time){
        int total_time=0;
        for(int i=0;i<arr.length;i++){
            total_time+=Math.ceil((double)arr[i]/(double)time);
        }
        return total_time;
    }
}
