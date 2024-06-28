import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        List<Integer> currTest = new ArrayList<>(); 
        List<List<Integer>> finalOutput = new ArrayList<>(); 
        backtrack(candidates, finalOutput, target, 0, currTest, 0);
        return finalOutput; 
    }

    public void backtrack(int[] candidates, List<List<Integer>> finalOutput, int target, int currentSum, List<Integer> currTest, int currIndex) {
        if (currentSum == target) {
            finalOutput.add(new ArrayList<>(currTest)); 
            return; 
        }

        if (currentSum > target) {
            return; 
        }

        for (int i = currIndex; i < candidates.length; i++) {
            if (i > currIndex && candidates[i] == candidates[i - 1]) continue; // Skip duplicates

            currTest.add(candidates[i]); 
            backtrack(candidates, finalOutput, target, currentSum + candidates[i], currTest, i + 1);
            currTest.remove(currTest.size() - 1); 
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = sol.combinationSum2(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
