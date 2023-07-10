// import java.util.*; 

// class Solution {
//     public void rotate(int[][] matrix) {
//         int m = matrix.length; 
//         int n = matrix[0].length; 
//         HashSet<List<Integer>> hs = new HashSet<>(); 
//         List<List<Integer>> lst = new ArrayList<>(); 
        
//         for(int i = 0; i < m ; i++ ){
//             for(int j = 0; j < n ; j++){
//                 ArrayList<Integer> newLst = new ArrayList<>(Arrays.asList(i, j)); 
//                 hs.add(newLst); 
//                 lst.add(newLst); 
//             }
//         }

//         while(!hs.isEmpty()){
//             while(true){
//                 List<Integer> testLst = lst.get(0); 
//                 if(hs.contains(testLst)){
//                     int x = testLst.get(0); 
//                     int y = testLst.get(1); 
//                     int oriX = x; 
//                     int oriY = y; 
//                     int newX = n - 1 - y; 
//                     int newY = x; 
//                     int temp = matrix[x][y];  
//                     while(true){
//                         matrix[newX][newY] = temp; 
// -*                        x = newX; 
//                         y = newY; 
//                         newX = n - 1 - y; 
//                         newY = x; 
//                         if(x == oriX && y == oriY){
//                             break; 
//                         }
//                     }
//                     break; 
//                 }
//                 testLst.remove(0); 
//             }
//         }
//     }
// }


class Solution {
    public void rotate(int[][] matrix) {
            // Step 1 - Find transpose of matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=0;
                temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        // step 2 - Reverse each row of matrix 
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]= temp;

            }
        }
        
    }
}
