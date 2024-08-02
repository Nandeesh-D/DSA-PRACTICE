package Arrays;
//problem: 283


/*
Algo:

1.First, using a loop, we will place the pointer j. If we don’t find any 0, we will not perform the following steps.
2.After that, we will point i to index j+1 and start moving the pointer using a loop.*/
public class MoveZeroesToEnd {

    public void moveZeroes(int[] nums) {
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) return;

        for(int i=j+1;i<nums.length;i++){
            if(nums[i]!=0){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                j++;
            }
        }
    }
}
