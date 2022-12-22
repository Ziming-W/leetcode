//backtracking
//DFS
import java.util.*; 
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length; 
        int n = grid[0].length; 
        int[] solutionQuery = new int[queries.length];
        boolean[] branchControl = new boolean[queries.length];  
        //matrix check which grid has been visited
        int[][] mark = new int[m][n];
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                mark[x][y] = 0; 
            }
        }
        int max = 0; 
        for(int i = 0; i < queries.length; i++){
            max = (queries[i] > max) ? queries[i] : max; 
            branchControl[i] = true; 
        }
        //hashtable to store visited information
        List<HashMap<List<Integer>, Integer>> visited = new ArrayList<>(); 
        solve(mark, grid, max, queries, solutionQuery, branchControl, 0, 0); 
        return solutionQuery; 
    }

    public void solve(int[][] mark, int[][] grid, int maxElem, int[] inputQuery, int[] solutionQuery, boolean[] branchControl, int x, int y){
        int m = grid.length; 
        int n = grid[0].length; 
        int leftX = x - 1; 
        int rightX = x + 1; 
        int upY = y - 1; 
        int downY = y + 1; 
        List<List<Integer>> candidates = new ArrayList<>(); 
        candidates.add(Arrays.asList(leftX, y)); 
        candidates.add(Arrays.asList(rightX, y)); 
        candidates.add(Arrays.asList(x, upY)); 
        candidates.add(Arrays.asList(x, downY)); 
        System.out.println("old" + Arrays.toString(branchControl)); 
        for(int i = 0; i < inputQuery.length; i++){
            solutionQuery[i] += (grid[x][y] < inputQuery[i] && mark[x][y] == 0 && branchControl[i]) ? 1 : 0; //local accumalator
            branchControl[i] = branchControl[i] && ((grid[x][y] < inputQuery[i]) ? true: false);
        }
        System.out.println("solve" + x + y + " " + solutionQuery[0]); 
        System.out.println("new" + Arrays.toString(branchControl)); 
        System.out.println(); 
        mark[x][y] = 1; 
        for(List<Integer> candidate:candidates){
            int candidateX = candidate.get(0); 
            int candidateY = candidate.get(1); 
            //System.out.println("test: " + candidateX + candidateY);
            if(0 <= candidateX && candidateX < m && 0 <= candidateY && candidateY < n && grid[candidateX][candidateY] < maxElem && mark[candidateX][candidateY] == 0){
                boolean[] newBranchContrl = Arrays.copyOf(branchControl, branchControl.length); 
                solve(mark, grid, maxElem, inputQuery, solutionQuery, newBranchContrl, candidateX, candidateY); 
            }
        }
    }
}