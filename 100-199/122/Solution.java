class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0; 
        int buy = 0; 
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[buy]){
                sum += prices[i] - prices[buy]; 
                buy = i; 
            }
            else{
                buy = i; 
            }
        }

        return sum; 
        
    }
}