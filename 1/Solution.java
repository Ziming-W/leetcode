// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for(int i = 0; i < nums.length-1; i++){
//             for(int j = i+1; j < nums.length; j++){
//                 if(nums[i] + nums[j] == target){
//                     return (new int[]{i, j}); 
//                 }
//             }
//         }
//         return null; 
//     }
// }

// 92% 82%
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], i); 
        }
        for(int i=0; i<nums.length; i++){
            int off = target - nums[i]; 
            if(hm.containsKey(off) && hm.get(off) != i){
                return new int[]{i, hm.get(off)}; 
            }
        }
        return null; 

    }
}


