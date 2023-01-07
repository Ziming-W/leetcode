import java.util.*;
//backtracking
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); 
        List<Integer> currTest = new ArrayList<Integer>(); 
        List<List<Integer>> solutions = new ArrayList<>(); 
        backtrack(solutions, candidates, target, 0, currTest);
        return solutions; 
    }

    public void backtrack(List<List<Integer>> solutions, int[] candidates, int target, int currSum, List<Integer> currTest){
        if(currSum == target){
            List<Integer> copyCurrTest = new ArrayList<Integer>(); 
            for(int test:currTest){
                copyCurrTest.add(test); 
            }
            solutions.add(copyCurrTest); 
            return;  
        }
        for(int candidate:candidates){
            //since the array is sorted already, only making progress by adding or equal number to previous number
            //avoid duplicates
            int last = currTest.size() == 0 ? -1 : currTest.get(currTest.size() - 1); 
            currTest.add(candidate);
            if(candidate >= last && currSum + candidate <= target){
                backtrack(solutions, candidates, target, currSum + candidate, currTest); 
            }
            currTest.remove(currTest.size() - 1);
        }

}
}