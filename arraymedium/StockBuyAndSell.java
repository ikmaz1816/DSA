package arraymedium;

public class StockBuyAndSell {
	 public int maxProfit(int[] prices) {
         int max=Integer.MIN_VALUE;
         int min=Integer.MAX_VALUE;
         int profit=0;
         for(int i:prices)
         {
            if(min>i)
            {
                min=i;
                max=i;
            }
            max=Math.max(max,i);
            profit=Math.max(profit,max-min);
         }
         return profit<=0 ? 0 : profit;
    }
}
