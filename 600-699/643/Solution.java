class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0; 
        for(int i = 0;i < k; i++){
            sum += nums[i]; 
        }
        int max = sum; 
        
        int len = nums.length; 

        for(int i = k; i < len; i++){
            sum += nums[i]; 
            sum -= nums[i-k]; 
            max = Math.max(max, sum);
        }

        return (double)max/k; 

    }
}