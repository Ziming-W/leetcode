import java.util.*; 
class Solution {
    public List<List<Integer>> permute(int[] nums) { 
        List<List<Integer>> pool = new ArrayList<>();
        pool.add(new ArrayList<>()); 
        for(int i = 0; i < nums.length; i++){
            List<Integer> copyCandidates = new ArrayList<>(); 
            for(int j = 0; j < nums.length; j++){
                if(j != i){
                    copyCandidates.add(nums[j]); 
                }
            }
            place(pool, copyCandidates); 
        }
        return pool; 
    }

    private void place(List<List<Integer>> pool, List<Integer> candidates){
        List<List<Integer>> newPool = new ArrayList<>(); 
        for(int candidate:candidates){
            for(List<Integer> permu:pool){
                List<Integer> permuCopy = new ArrayList<>();
                //copy existing elements
                for(int p:permu){
                    permuCopy.add(p); 
                }
                //add new 
                permuCopy.add(candidate);
                newPool.add(permuCopy); 
            }
        }
        pool = newPool; 
    }
}