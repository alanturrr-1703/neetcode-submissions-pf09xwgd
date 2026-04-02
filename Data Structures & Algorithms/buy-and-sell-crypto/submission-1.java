class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0;
        for(int r = 0; r < prices.length; r++){
            int profit = prices[r] - prices[l];
            if(profit < 0) l = r;
            max = Math.max(max, profit);
        }
        return max;
    }
}
