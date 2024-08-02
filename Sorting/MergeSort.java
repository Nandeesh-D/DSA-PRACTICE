package Sorting;


import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr={5,2,3,1};
        int[] ans=merge_sort(arr);
        System.out.println(Arrays.toString(ans));
        merge_sort_inplace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] merge_sort(int[] nums){
        if(nums.length==1) return nums;

        int mid=nums.length/2;

        int[] left=merge_sort(Arrays.copyOfRange(nums,0,mid));
        int[] right=merge_sort(Arrays.copyOfRange(nums,mid,nums.length));

         return merge(left,right);
    }

    private  static int[] merge(int[] left,int[] right){
        int[] ans=new int[left.length+right.length];

        int i=0;  //to point left array
        int j=0;  //to point right array
        int k=0;  //to point ans array

        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                ans[k]=left[i];
                i++;
                k++;
            }else{
                ans[k]=right[j];
                j++;
                k++;
            }
        }

        //if elements of one of the array are left
        while(i<left.length){
            ans[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            ans[k]=right[j];
            j++;
            k++;
        }

        return ans;
    }

    //merge sort inplace
    public static void merge_sort_inplace(int[] nums,int s,int e){
        if(e-s==1) return;

        int mid=(s+e)/2;

        merge_sort_inplace(nums,s,mid);
        merge_sort_inplace(nums,mid,e);

        merge(nums,s,mid,e);
    }

    private  static void merge(int[] nums,int s,int m,int e){
        int[] ans=new int[e-s];

        int i=s;  //to point left array
        int j=m;  //to point right array
        int k=0;  //to point ans array

        while(i<m && j<e){
            if(nums[i]<nums[j]){
                ans[k]=nums[i];
                i++;
                k++;
            }else{
                ans[k]=nums[j];
                j++;
                k++;
            }
        }

        //if elements of one of the array are left
        while(i<m){
            ans[k]=nums[i];
            i++;
            k++;
        }
        while(j<e){
            ans[k]=nums[j];
            j++;
            k++;
        }

        for(k=0;k<ans.length;k++){
            nums[s+k]=ans[k];
        }
    }
}
