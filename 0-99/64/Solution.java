import java.util.*; 
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        int[][] dp = new int[m][n]; 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 & j == 0){
                    dp[i][j] = grid[i][j]; 
                    continue; 
                }
                int min = Integer.MAX_VALUE; 
                int leftY = j - 1; 
                int upX = i - 1; 
                if(leftY >= 0){
                    min = Math.min(min, dp[i][leftY]);  
                }
                if(upX >= 0 ){
                    min = Math.min(min, dp[upX][j]); 
                }
                dp[i][j] = grid[i][j] + min; 
            }
        } 
        return dp[m-1][n-1]; 
    }
}