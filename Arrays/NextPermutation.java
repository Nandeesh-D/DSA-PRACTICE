package Arrays;
//problem:31
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int ind=-1;  //to store break point
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
       }

        if(ind==-1){  //next permutation is it's sorted form
            reverse(nums,0,n-1);
            return;
        }

        for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){  //next smallest element which is >= break element that is  nums[ind]
                int t=nums[i];
                nums[i]=nums[ind];
                nums[ind]=t;
                break;
            }
        }
        //reverse the right half after the ind
        reverse(nums,ind+1,n-1);
}

    public void reverse(int[] arr,int s,int e){
            while(s<e){
                int t=arr[s];
                arr[s]=arr[e];
                arr[e]=t;
                s++;
                e--;
            }
    }
}
