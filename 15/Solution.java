//Time: O(n^2), hash table
import java.util.*; 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> al = new ArrayList<List<Integer>>(); 
        HashMap<Integer, Integer> hm = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1); 
        }
        for(int i = 0; i < nums.length -1; i++){
            for(int j = i+1; j < nums.length; j++){
                System.out.println(0-(nums[i]+nums[j])); 
                if(hm.getOrDefault(0-(nums[i]+nums[j]), 0) > 1 && (0-(nums[i]+nums[j])) >= nums[j] ){
                    List<Integer> newL = new ArrayList<Integer>(); 
                    newL.add(nums[i]); 
                    newL.add(nums[j]); 
                    newL.add(0-(nums[i]+nums[j])); 
                    al.add(newL); 
                }
            }
        }
        return al; 
    }
}
