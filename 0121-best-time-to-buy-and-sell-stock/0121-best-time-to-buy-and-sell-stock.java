class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int p = 0;
        for(int i = 1 ; i < prices.length ; i++){
            int c = prices[i] - min;
            p = Math.max(c,p);
            min = Math.min(min,prices[i]);
        }
        return p;
    }
}