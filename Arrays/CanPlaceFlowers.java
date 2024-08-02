package Arrays;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for(int i=0;i<flowerbed.length;i++){
            //we  can plant a plant in a empty slot having both left and right plots are empty
            if(flowerbed[i]==0){
                boolean leftPlot= (i==0) || flowerbed[i-1]==0;
                boolean rightPlot=(i==flowerbed.length-1) || flowerbed[i+1]==0;

                if(leftPlot && rightPlot){
                    count++;
                    flowerbed[i]=1;
                    if(count>=n) return true;
                }
            }
        }
        return false;
    }
}
