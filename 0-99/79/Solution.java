import java.util.*;

class Solution {
    List<List<Integer>> directionsOffset = new ArrayList<>();

    public Solution() {
        directionsOffset.add(new ArrayList<>(Arrays.asList(1, 0)));
        directionsOffset.add(new ArrayList<>(Arrays.asList(0, 1)));
        directionsOffset.add(new ArrayList<>(Arrays.asList(-1, 0)));
        directionsOffset.add(new ArrayList<>(Arrays.asList(0, -1)));
    }

    private boolean isValidMove(int x, int y, int m, int n, List<List<Integer>> path) {
        if (!(x >= 0 && x < m) || !(y >= 0 && y < n)) {
            return false;
        }
        for (List<Integer> lst : path) {
            if (lst.get(0) == x && lst.get(1) == y) {
                return false;
            }
        }
        return true;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        return backTrack(board, "", word, directionsOffset, m, n);
    }

    private boolean backTrack(char[][] board, String temp, String word, List<List<Integer>> path, int m, int n) {
        if (temp.equals(word)) { // Use equals for string comparison
            return true;
        }
        // if empty
        if (path.size() == 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    List<List<Integer>> newPath = new ArrayList<>(path);
                    newPath.add(new ArrayList<>(Arrays.asList(i, j)));
                    if (backTrack(board, "" + board[i][j], word, newPath, m, n)) {
                        return true;
                    }
                }
            }
        }
        // if not empty
        else {
            List<Integer> prev = path.get(path.size() - 1);
            for (List<Integer> offset : directionsOffset) {
                int x = prev.get(0) + offset.get(0);
                int y = prev.get(1) + offset.get(1);
                if (isValidMove(x, y, m, n, path)) {
                    List<List<Integer>> newPath = new ArrayList<>(path);
                    newPath.add(new ArrayList<>(Arrays.asList(x, y)));
                    if (backTrack(board, temp + board[x][y], word, newPath, m, n)) {
                        return true;
                    }
                }
            }
        }
    
        return false; 
    }
}
