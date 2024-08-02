package Stacks;

public class TrappingRainWater {


    //optimal approach - two pointer
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int maxWater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {   //condition to make sure that some building with >= height exists on right of cur left building
                if (height[left] >= leftMax) leftMax = height[left];
                else maxWater += leftMax - height[left];
                left++;
            } else {     //condition to make sure that some building with >= height exists on left of cur right building
                if (height[right] >= rightMax) rightMax = height[right];
                else maxWater += rightMax - height[right];
                right--;
            }

        }
        return maxWater;
    }

    //using prefix sum
    static int trap1(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTrapped;
    }
}
