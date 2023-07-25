import java.util.*; 

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>(); 
        int m = matrix.length; 
        int n = matrix[0].length; 
        // if(m == 0 || n == 0){
        //     return null; 
        // }
        if(m == 1 || n == 1){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    output.add(matrix[i][j]); 
                }
            }
        }
        else{
            //append outer wrap
            for(int j = 0; j < n; j++){
                output.add(matrix[0][j]); 
            }
            for(int i = 1; i < m; i++){
                output.add(matrix[i][n - 1]); 
            }
            for(int j = n-2; j >=0; j--){
                output.add(matrix[m - 1][j]); 
            }
            for(int i = m-2; i >= 1; i--){
                output.add(matrix[i][0]); 
            }
            // recursively append inner matrix
            if(m == 2 || n ==2){
                return output; 
            }
            int[][] inner = new int[m-2][n-2]; 
            for(int i = 0; i < m-2; i++){
                for(int j = 0; j < n -2; j++){
                    inner[i][j] = matrix[i+1][j+1]; 
                }
            }
            output.addAll(spiralOrder(inner)); 
        }
        return output; 
    }
}
