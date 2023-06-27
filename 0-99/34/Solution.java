import java.util.*;
//not efficient if too many targets
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target); 
        if(index < 0){
            return new int[]{-1, -1}; 
        }
        int i, j; 
        i = j = index;
        boolean incI, incJ; 
        incI = incJ = true; 
        while(incI || incJ){
            if(i < 0 || (i >= 0 && nums[i] != target)){
                incI = false; 
            }
            if(incI){
                i--; 
            }
            if(j >= nums.length || (j < nums.length && nums[j] != target)){
                incJ = false; 
            }
            if(incJ){
                j++; 
            }
        }
        return new int[]{++i, --j}; 
    }
}
