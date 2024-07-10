// class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length; 
//         boolean[] dp = new boolean[n]; 
//         dp[0] = true; 
//         for(int i = 1; i < n; i++){
//             for(int j = 0; j < i; j++){
//                 if(dp[j] && j + nums[j] >= i){
//                     dp[i] = true; 
//                     break; 
//                 }
//             } 
//         }
//         return dp[n - 1]; 

//     }
// }

import java.util.Arrays;

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;

        boolean[] dp = new boolean[len];
        dp[0] = true; 
        
        for (int i = 0; i < len-1; i++) {
            for (int j = i + 1; j < Math.min(i + nums[i] + 1, nums.length); j++) {
                dp[j] = true;
            }
        }

        System.out.println(Arrays.toString(dp)); 

        for (int i = 0; i < len; i++) {
            if (!dp[i])
                return false;
        }
        return true;
    }
}
