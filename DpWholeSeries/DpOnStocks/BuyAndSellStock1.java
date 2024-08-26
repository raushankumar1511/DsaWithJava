package DpWholeSeries.DpOnStocks;

public class BuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profitMax = 0;
        int n = prices.length;

        for(int i = 1; i<n; i++){
            int cost = prices[i] - minPrice;
            profitMax = Math.max(profitMax, cost);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profitMax;
    }
}
