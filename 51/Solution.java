import java.util.*;

//stupid backtracking? works, but stackoverflow if n>= 8
// class Solution {
//     public static List<List<String>> solveNQueens(int n) {
//         //initial input
//         List<List<Integer>> initialTest = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             ArrayList<Integer> temp = new ArrayList<>();
//             for(int j = 0; j < n; j++){
//                 if(j == 0){
//                     temp.add(1); 
//                 }
//                 else{
//                     temp.add(0); 
//                 }
//             }
//             initialTest.add(temp);
//         }
//         List<List<List<Integer>>> store = new ArrayList<>(); 
//         backtrack(initialTest, store, n); 
//         List<List<String>> allSolutionStringStore = new ArrayList<>(); 
//         for(List<List<Integer>> solution:store){
//             List<String> singleSolutionStringStore = new ArrayList<>(); 
//             for(List<Integer> row:solution){
//                 String str = new String(); 
//                 for(int point:row){
//                     str += ((point == 1) ? "Q" : "."); 
//                 }
//                 singleSolutionStringStore.add(str); 
//             }
//             allSolutionStringStore.add(singleSolutionStringStore); 
//         }
//         return allSolutionStringStore; 
//     }

//     private static List<List<List<Integer>>> backtrack(List<List<Integer>> test, List<List<List<Integer>>> store, int n){
//         //if valid, add to store
//         if(verify(test, n)){
//             store.add(copyTest(test, n)); 
//         }
//         //if the last one to be tested, return store
//         boolean allEnd = true; 
//         for(int i = 0; i < n; i++){
//             if(test.get(i).get(n-1) == 0){
//                 allEnd = false; 
//                 break; 
//             }
//         }
//         if(allEnd){
//             return store; 
//         }
//         //else, increase the last one and keep backtracking
//         for(int i = n-1; i>=0; i--){
//             int y = 0; 
//             for(int j = 0; j < n; j++){
//                 if(test.get(i).get(j) == 1){
//                     y = j; 
//                     break; 
//                 }
//             }
//             //if the last one already, move the marker to the beginning of the line, break
//             //otherwisekeep searching to last line
//             if(y == n-1){
//                 test.get(i).set(y, 0); 
//                 test.get(i).set(0, 1); 
//             }
//             else{
//                 test.get(i).set(y, 0); 
//                 test.get(i).set(y + 1, 1); 
//                 break; //stop here
//             }
//         }
//         //now, keep backtracking
//         return backtrack(test, store, n); 
//     }

//     private static boolean verify(List<List<Integer>> test, int n){
//         //verify rows
//         for(int i = 0; i < n; i++){
//             boolean show = false;
//             for(int j = 0; j < n; j++){
//                 if(test.get(i).get(j) == 1 && show){
//                     return false; 
//                 }
//                 else if(test.get(i).get(j) == 1 && !show){
//                     show = true; 
//                 }
//             }
//         }
//         //verify columns
//         for(int i = 0; i < n; i++){
//             boolean show = false;
//             for(int j = 0; j < n; j++){
//                 if(test.get(j).get(i) == 1 && show){
//                     return false; 
//                 }
//                 else if(test.get(j).get(i) == 1 && !show){
//                     show = true; 
//                 }
//             }
//         }
//         //verify dia
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 if(test.get(i).get(j) == 1){
//                     if(!verifyDia(test, n, i, j)){
//                         return false; 
//                     }
//                 }
//             }
//         }
//         return true; 
//     }

//     public static boolean verifyDia(List<List<Integer>> test, int n, int x, int y){
//         int i, j; 
//         i = x; 
//         j = y; 
//         //left lean
//         //go upper left
//         while(--i >= 0 && --j >= 0){
//             if(test.get(i).get(j) == 1){
//                 return false; 
//             }
//         }
//         i = x; 
//         j = y; 
//         //go bottom right
//         while(++i < n && ++j < n){
//             if(test.get(i).get(j) == 1){
//                 return false; 
//             }
//         }
//         i = x; 
//         j = y; 
//         //right lean
//         //go upper right
//         while(--i >=0 && ++j < n){
//             if(test.get(i).get(j) == 1){
//                 return false; 
//             }
//         }
//         i = x; 
//         j = y; 
//         //go bottom left
//         while(++i < n && --j >= 0){
//             if(test.get(i).get(j) == 1){
//                 return false; 
//             }
//         }
//         return true; 
//     }

//     private static List<List<Integer>> copyTest(List<List<Integer>> test, int n){
//         List<List<Integer>> copy = new ArrayList<>(); 
//         for(int i = 0; i < n; i++){
//             ArrayList<Integer> temp = new ArrayList<>();
//             for(int j = 0; j < n; j++){
//                  temp.add(test.get(i).get(j)); 
//             }
//             copy.add(temp); 
//         }
//         return copy; 
//     }

//     public static void main(String[] args){
//         System.out.println(solveNQueens(8));
//         // List<List<Integer>> test = new ArrayList<>(); 
//         // test.add(Arrays.asList(1, 0, 0, 0)); 
//         // test.add(Arrays.asList(0, 1, 0, 0));
//         // test.add(Arrays.asList(0, 0, 1, 0));
//         // test.add(Arrays.asList(0, 0, 0, 1));
//         // System.out.println(verify(test, 4)); 
//     }
// }

//improved version
class Solution {
    public static List<List<String>> solveNQueens(int n) {
        //initial input
        List<List<Integer>> initialTest = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                temp.add(0); 
            }
            initialTest.add(temp);
        }
        //generate all solutions (0-1 representation)
        List<List<List<Integer>>> solutions = new ArrayList<>(); 
        backtrack(solutions, initialTest, 0, n); 
        //output to required string form
        List<List<String>> allSolutionStringStore = new ArrayList<>(); 
        for(List<List<Integer>> solution:solutions){
            List<String> singleSolutionStringStore = new ArrayList<>(); 
            for(List<Integer> row:solution){
                String str = new String(); 
                for(int point:row){
                    str += ((point == 1) ? "Q" : "."); 
                }
                singleSolutionStringStore.add(str); 
            }
            allSolutionStringStore.add(singleSolutionStringStore); 
        }
        return allSolutionStringStore; 
    }

    private static void backtrack(List<List<List<Integer>>> solutions, List<List<Integer>> test, int column, int n){
        if(column == n){
            solutions.add(copyTest(test, n)); 
            return; 
        }
        for(int i = 0; i < n; i++){
            test.get(i).set(column, 1); 
            if(verifyPlacement(test, n, i, column)){
                backtrack(solutions, test, column+1, n); 
            }
            test.get(i).set(column, 0);  
        }
    }

    private static boolean verifyPlacement(List<List<Integer>> test, int n, int x, int y){
        //check row
        for(int j = 0; j < n; j++){
            if(j != y && test.get(x).get(j) == 1){
                return false; 
            }
        }
        //check column
        for(int i = 0; i < n; i++){
            if(i != x && test.get(i).get(y) == 1){
                return false; 
            }
        }
        //check dia
        if(!verifyDia(test, n, x, y)){
            return false; 
        }
        return true; 
    }

    public static boolean verifyDia(List<List<Integer>> test, int n, int x, int y){
        int i, j; 
        i = x; 
        j = y; 
        //left lean
        //go upper left
        while(--i >= 0 && --j >= 0){
            if(test.get(i).get(j) == 1){
                return false; 
            }
        }
        i = x; 
        j = y; 
        //go bottom right
        // while(++i < n && ++j < n){
        //     if(test.get(i).get(j) == 1){
        //         return false; 
        //     }
        // }
        // i = x; 
        // j = y; 
        //right lean
        //go upper right
        // while(--i >=0 && ++j < n){
        //     if(test.get(i).get(j) == 1){
        //         return false; 
        //     }
        // }
        // i = x; 
        // j = y; 
        //go bottom left
        while(++i < n && --j >= 0){
            if(test.get(i).get(j) == 1){
                return false; 
            }
        }
        return true; 
    }

    private static List<List<Integer>> copyTest(List<List<Integer>> test, int n){
        List<List<Integer>> copy = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                 temp.add(test.get(i).get(j)); 
            }
            copy.add(temp); 
        }
        return copy; 
    }

    public static void main(String[] args){
        System.out.println(solveNQueens(8));
        // List<List<Integer>> test = new ArrayList<>(); 
        // test.add(Arrays.asList(1, 0, 0, 0)); 
        // test.add(Arrays.asList(0, 1, 0, 0));
        // test.add(Arrays.asList(0, 0, 1, 0));
        // test.add(Arrays.asList(0, 0, 0, 1));
        // System.out.println(verify(test, 4)); 
    }
}


