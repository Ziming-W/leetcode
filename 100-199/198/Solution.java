import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length; 
        if(len == 1){
            return nums[0]; 
        }

        int[] dp = new int[nums.length]; 
        dp[0] = nums[0]; 
        dp[1] = Math.max(nums[1], nums[0]); 

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]); 
        }

        System.out.println(Arrays.toString(dp)); 
        return Math.max(dp[len-1], dp[len-2]); 
        
    }
}


// 2 7 11 11 12