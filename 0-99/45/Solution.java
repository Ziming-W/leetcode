import java.util.*; 
class Solution {
    public static int jump(int[] nums) {
        int n = nums.length; 
        int[] minArray = new int[n]; 
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         dp[i][j] = Integer.MAX_VALUE; 
        //     }
        // }
        for(int i = 0; i < n; i++){
            minArray[i] = Integer.MAX_VALUE; 
        }
        minArray[0] = 0; 

        //initial first ArrayList
        for(int i = 1; i < n ; i++){
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    minArray[i] = Math.min(minArray[j] + 1, minArray[i]); 
                }
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(dp[i][j]  + " "); 
        //     }
        //     System.out.println(); 
        // }
        return minArray[n-1];  
    }

    public static void main(String[] args){
        System.out.println(jump(new int[]{2, 3, 1, 1, 4})); 
    }
}