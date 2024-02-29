import java.util.*; 

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>(); 
        output.add(new ArrayList<>()); 
        for(int i = 0; i < nums.length; i++){
            int fixedSize = output.size(); 
            for(int j = 0; j < fixedSize; j++){
                List<Integer> dup = new ArrayList<>(); 
                dup.addAll(output.get(j)); 
                dup.add(nums[i]); 
                output.add(dup); 
            }
        }
        return output; 
    }
}



