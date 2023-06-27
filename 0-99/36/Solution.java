// 69% 86%
import java.util.HashMap; 

class Solution {
    private static final int size = 9; 
    public static boolean isValidSudoku(char[][] board) {
        //verify rows
        boolean validRows = true; 
        for(int i = 0; i < size ; i++){
            validRows  = validRows && verifyRow(board[i]); 
            if(!validRows){
                return false; 
            }
        }
        //verify columns
        boolean validColumns = true; 
        char[][] tranposeMatrix = transposeMatrix(board); 
        for(int i = 0; i < size; i++){
            validColumns = validColumns && verifyRow(tranposeMatrix[i]); 
            if(!validColumns){
                return false; 
            }
        }
        //verify grids
        boolean validGrids = true; 
        char[][] grids; 
        for(int i = 0; i <= 6; i+=3){
            for(int j = 0; j <= 6; j += 3){
                char[] singleGrid = new char[size]; 
                int k = 0; 
                for(int m = i; m < i + 3; m++){
                    for(int n = j; n < j + 3; n++){
                        singleGrid[k] = board[m][n]; 
                        k++; 
                    }
                }
                validGrids = validGrids && verifyRow(singleGrid); 
                if(!validGrids){
                    return false; 
                }
            }
        }
        return true; 
    }

    private static boolean verifyRow(char[] row){
        //1-9 or dot
        for(int i = 0; i < size; i++){
            if(!(Character.isDigit(row[i]) || row[i] == '.')){
                return false; 
            }
        }
        //dup or not
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i < size; i++){
            int count = hm.getOrDefault(row[i], 0); 
            if(row[i] != '.' && count > 0){
                return false; 
            }
            hm.put(row[i], count + 1); 
        }
        return true; 
    }

    private static char[][] transposeMatrix(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
    
        char[][] transposedMatrix = new char[n][m];
    
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                transposedMatrix[x][y] = matrix[y][x];
            }
        }
    
        return transposedMatrix;
    }

    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}; 
        System.out.println(isValidSudoku(board)); 
    }

}
