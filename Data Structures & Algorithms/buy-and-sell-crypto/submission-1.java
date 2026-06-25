class Solution {
    public int maxProfit(int[] prices) {
        int highestDiff = 0;
        int highestSell = 0;
        for (int i=prices.length-1;i>=0;i--){
            if(highestSell < prices[i]){
                highestSell = prices[i];
            } else {
                int diff = highestSell - prices[i];
                if(highestDiff < diff){
                    highestDiff = diff;
                }
            }
        }
        return highestDiff;
    }
}
