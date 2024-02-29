import java.util.Arrays;

class Solution {
    // b search
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        int n = matrix[0].length; 
        int start = 0; 
        int end = m*n - 1; 
        
        while(start <= end){
            int i = start + (end - start) /2; 
            if(matrix[i/n][i%n] == target){
                return true; 
            }
            else if(matrix[i/n][i%n] < target){
                start = i + 1; 
            }
            else{
                end = i - 1;
            }
        }
        return false; 
    }

}