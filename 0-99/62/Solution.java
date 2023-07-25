import java.util.*; 


//backtracking, works, but TLE
// class Solution {
//     public int uniquePaths(int m, int n) {
//         List<Integer> oriPoint = new ArrayList<>(Arrays.asList(0, 0)); 
//         List<List<Integer>> oriPath = new ArrayList<>(); 
//         HashSet<List<Integer>> oriSet = new HashSet<>(); 
//         oriPath.add(oriPoint); 
//         oriSet.add(oriPoint); 
//         return backtrack(0, 0, oriPath, oriSet, m, n); 
//     }

//     public List<List<Integer>> generateNeighbours(int x, int y, int m, int n, HashSet<List<Integer>> hs){
//         List<List<Integer>> candidates = new ArrayList<>(); 
//         List<List<Integer>> output = new ArrayList<>(); 
//         //down or right
//         candidates.add(new ArrayList<>(Arrays.asList(x + 1, y))); 
//         //candidates.add(new ArrayList<>(Arrays.asList(x - 1, y))); 
//         candidates.add(new ArrayList<>(Arrays.asList(x, y + 1))); 
//         //candidates.add(new ArrayList<>(Arrays.asList(x, y - 1)));
//         for(List<Integer> candidate:candidates){
//             if(validPoint(candidate.get(0), candidate.get(1), m, n) && !hs.contains(candidate)){
//                 output.add(candidate); 
//             }
//         }
//         return output; 
//     }

//     public boolean validPoint(int x, int y, int m, int n){
//         return (x >= 0 && x < m && y >= 0 && y < n); 
//     }

//     public int backtrack(int x, int y, List<List<Integer>> path, HashSet<List<Integer>> hs, int m, int n){
//         if(x == m-1 && y == n-1){
//             // for(List<Integer> lst:path){
//             //     System.out.println(lst.get(0) + " " + lst.get(1)); 
//             // }
//             // System.out.println("---------------"); 

//             return 1; 
//         }
//         else{
//             int counter = 0; 
//             for(List<Integer> candidate:generateNeighbours(x, y, m, n, hs)){
//                 int newX = candidate.get(0); 
//                 int newY = candidate.get(1); 
//                 List<Integer> newPoint = new ArrayList<>(Arrays.asList(newX, newY)); 
//                 path.add(newPoint); 
//                 hs.add(newPoint); 
//                 counter += backtrack(newX, newY, path, hs, m, n); 
//                 path.remove(newPoint); 
//                 hs.remove(newPoint); 
//             }
//             return counter; 
//         }
//     }
// }


//dp
class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; 
        dp[0][0] = 1; 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue; 
                }
                int leftY = j - 1; 
                int upX = i - 1; 
                if(leftY >= 0){
                    dp[i][j] += dp[i][leftY];  
                }
                if(upX >= 0 ){
                    dp[i][j] += dp[upX][j]; 
                }
            }
        }
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(dp[i][j] + " ");  
        //     }
        //     System.out.println(); 
        // }
        return dp[m-1][n-1]; 

    }
}   