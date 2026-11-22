class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1;i<N;i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit,profit);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}
