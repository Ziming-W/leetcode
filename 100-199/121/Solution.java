class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE; 
        int max = -1; 
        int minIndex = -1; 
        int maxIndex = -1; 
        int maxProfit = 0; 

        for(int i = 0; i < prices.length;i++){
            int temp = prices[i]; 
            if(temp < min){
                min = temp; 
                minIndex = i; 
            }
            if(temp > max || minIndex > maxIndex){
                max = temp; 
                maxIndex = i; 
            }
            if(minIndex < maxIndex){
                maxProfit = Math.max(maxProfit, max - min); 
            }
        }

        return maxProfit; 
        
    }
}