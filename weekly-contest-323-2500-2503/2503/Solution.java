//BFS success but TLE
import java.util.*; 
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        //sorted queries
        int[] sortedQueries = new int[queries.length]; 
        for(int i = 0; i < queries.length; i++){
            sortedQueries[i] = queries[i]; 
        }
        Arrays.sort(sortedQueries); 
        //initial q with upper left 0 0
        List<List<Integer>> q = new ArrayList<>();
        q.add(Arrays.asList(0, 0)); 
        //visited points 
        boolean[][] visited = new boolean[grid.length][grid[0].length]; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                visited[i][j] = false; 
            }
        }
        //store result queries
        Map<Integer, Integer> resultHM = new HashMap<>(); 
        int[] prevCount = {0}; 
        //run bfs asce
        for(int i = 0;  i < queries.length; i++){
            q = bfs(q, sortedQueries[i], prevCount, queries, resultHM, visited, grid);
        }
        //output result queries
        int[] resultQueries = new int[queries.length]; 
        for(int i = 0; i < queries.length; i++){
            resultQueries[i] = resultHM.get(queries[i]); 
        }
        return resultQueries; 
    }

    public List<List<Integer>> bfs(List<List<Integer>> q, int currQElem, int[] prevCount, int[] queries, Map<Integer, Integer> resultHM, boolean[][] visited, int[][] grid){
        List<List<Integer>> newQ = new ArrayList<>(); 
        int count = 0; 
        while(!q.isEmpty()){
            List<Integer> currPoint = q.remove(0); 
            int x = currPoint.get(0); 
            int y = currPoint.get(1); 
            //check availability of curr grid point
            if(visited[x][y]){
                continue; 
            } 
            // if grid point is bigger or equal to currQElem,
            // no need to check neighbours here, add to new Q directly
            // and don't mark this point as visited
            if (currQElem <= grid[x][y]) {
                newQ.add(Arrays.asList(x, y));
                continue;
            }
            //visit this point
            visited[x][y] = true; 
            //update current count
            count ++; 
            //check neighbours
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
            for(List<Integer> candidate:candidates){
                int candidateX = candidate.get(0); 
                int candidateY = candidate.get(1); 
                if(0 <= candidateX && candidateX < m && 0 <= candidateY && candidateY < n && !visited[candidateX][candidateY]){
                    if(currQElem > grid[candidateX][candidateY]){
                        q.add(Arrays.asList(candidateX, candidateY)); 
                    }
                    else{
                        newQ.add(Arrays.asList(candidateX, candidateY)); 
                    }
                } 
            }
        }
        count += prevCount[0]; 
        prevCount[0] = count; 
        resultHM.put(currQElem, count); 
        //System.out.println(newQ.toString()); 
        return newQ; 
    }
       
}