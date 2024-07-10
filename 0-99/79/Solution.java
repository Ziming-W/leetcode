// import java.util.*;

// class Solution {
//     private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
//     public boolean exist(char[][] board, String word) {
//         int m = board.length;
//         int n = board[0].length;
//         boolean[][] visited = new boolean[m][n];
        
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (board[i][j] == word.charAt(0) && backtrack(board, word, visited, i, j, 0)) {
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }
    
//     private boolean backtrack(char[][] board, String word, boolean[][] visited, int x, int y, int index) {
//         if (index == word.length()) {
//             return true;
//         }
        
//         if (x < 0 || x >= board.length || y < 0 || y >= board[0].length 
//             || visited[x][y] || board[x][y] != word.charAt(index)) {
//             return false;
//         }
        
//         visited[x][y] = true;
        
//         for (int[] dir : DIRECTIONS) {
//             int newX = x + dir[0];
//             int newY = y + dir[1];
//             if (backtrack(board, word, visited, newX, newY, index + 1)) {
//                 return true;
//             }
//         }
        
//         visited[x][y] = false;
        
//         return false;
//     }
// }


import java.util.*;

class Solution {
    List<List<Integer>> directionsOffset = new ArrayList<>();

    public Solution() {
        directionsOffset.add(new ArrayList<>(Arrays.asList(1, 0)));
        directionsOffset.add(new ArrayList<>(Arrays.asList(0, 1)));
        directionsOffset.add(new ArrayList<>(Arrays.asList(-1, 0)));
        directionsOffset.add(new ArrayList<>(Arrays.asList(0, -1)));
    }

    private boolean isValidMove(int x, int y, int m, int n, boolean[][] visited) {
        if (!(x >= 0 && x < m) || !(y >= 0 && y < n)) {
            return false;
        }
        if(visited[x][y]){
            return false; 
        }
        return true;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n]; 
        return backTrack(board, word, 0, m, n,-1, -1, visited);
    }

    private boolean backTrack(char[][] board, String word, int index, int m, int n, int x, int y, boolean[][] visited) {
        if(index == word.length()){
            return true; 
        }

        // if empty
        if (index == 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j] == word.charAt(0)){
                        visited[i][j] = true; 
                        if (backTrack(board, word, 1, m, n, i, j,  visited)) {
                            return true;
                        }
                        visited[i][j] = false; 
                    }
                    
                }
            }
        }

        // if not empty
        else {
            for (List<Integer> offset : directionsOffset) {
                int newX = x + offset.get(0); 
                int newY = y + offset.get(1); 

                if (isValidMove(newX, newY, m, n, visited) && board[newX][newY] == word.charAt(index)) {
                    visited[newX][newY] = true; 
                    if (backTrack(board, word, index+1, m, n, newX, newY, visited)) {
                        return true;
                    }
                    visited[newX][newY] = false; 
                }
            }
        }
    
        return false; 
    }
}
