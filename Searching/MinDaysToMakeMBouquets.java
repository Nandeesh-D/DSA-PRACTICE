package Searching;
//problem:1482
public class MinDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;  //total no of flowers required
        int n = bloomDay.length; // Size of the array
        if (val > n) return -1; // Impossible case.-total required flowers < total available flowers
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int ans=maxi;
        while(mini<=maxi){
            int mid=(mini+maxi)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans=mid;
                maxi=mid-1;
            }else{
                mini=mid+1;
            }
        }
        return ans;
    }


    public boolean isPossible(int[] arr,int day,int m,int k){
        int cnt=0;
        int noOfBoques=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                cnt++;
            }else{
                noOfBoques+=(cnt/k);
                cnt=0;
            }
        }
        noOfBoques+=(cnt/k);
        if(noOfBoques>=m) return true;
        return false;
    }
}
