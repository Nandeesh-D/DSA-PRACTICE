package Arrays;
//problem:121
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
       int profit=0;
       int min=prices[0];
       for(int i=1;i<prices.length;i++){
           int cost=prices[i]-min;  //current profit that we get if we sell it today
           profit=Math.max(profit,cost);
           min=Math.min(min,prices[i]);
       }
       return profit;
    }

}
