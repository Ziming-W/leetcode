import java.util.*; 
class Solution {
    //space: O(m+n)
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowIndices = new HashSet<>(); 
        HashSet<Integer> colIndices = new HashSet<>(); 
        int m = matrix.length; 
        int n = matrix[0].length; 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rowIndices.add(i); 
                    colIndices.add(j); 
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rowIndices.contains(i) || colIndices.contains(j)){
                    matrix[i][j] = 0; 
                }
            }
        }
        
    }
}