//backtracking
//DFS
import java.util.*; 
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length; 
        int n = grid[0].length; 
        int[] solutionQuery = new int[queries.length]; 
        for(int i = 0; i < queries.length; i++){
            //the matrix for checking which point has been visited
            int[][] mark = new int[m][n]; 
            for(int x = 0; x < m; x++){
                for(int y = 0; y < n; y++){
                    mark[x][y] = 0; 
                }
            }
            solutionQuery[i] = (grid[0][0] < queries[i])? solve(mark, grid, queries[i], 0, 0) : 0; 
        }
        return solutionQuery; 
    }

    public int solve(int[][] mark, int[][] grid, int input, int x, int y){
        int m = grid.length; 
        int n = grid[0].length; 
        int leftX = x - 1; 
        int rightX = x + 1; 
        int upY = y - 1; 
        int downY = y + 1; 
        System.out.println("solve" + x + y); 
        List<List<Integer>> candidates = new ArrayList<>(); 
        candidates.add(Arrays.asList(leftX, y)); 
        candidates.add(Arrays.asList(rightX, y)); 
        candidates.add(Arrays.asList(x, upY)); 
        candidates.add(Arrays.asList(x, downY)); 
        //System.out.println(candidates + "\n"); 
        int localAcc = (grid[x][y] < input && mark[x][y] == 0) ? 1 : 0; //local accumalator
        mark[x][y] = 1; 
        for(List<Integer> candidate:candidates){
            int candidateX = candidate.get(0); 
            int candidateY = candidate.get(1); 
            //System.out.println("test: " + candidateX + candidateY);
            if(0 <= candidateX && candidateX < m && 0 <= candidateY && candidateY < n && grid[candidateX][candidateY] < input && mark[candidateX][candidateY] == 0){
                localAcc += solve(mark, grid, input, candidateX, candidateY); 
            }
        }
        return localAcc; 
    }
}