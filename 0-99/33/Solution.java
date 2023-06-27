import java.util.*;
//too complex should use index iteration
class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0); 
    }
    public int search(int[] nums, int target, int acc){
        int len = nums.length; 
        if(len == 0){
            return -1; 
        }
        if(len == 1){
            return target == nums[0] ? acc : -1; 
        }
        int midIndex = len / 2;
        int mid = nums[midIndex]; 
        if(mid == target){
            return acc + midIndex; 
        }
        else{
            if(mid > target){
                if(nums[0] <= target || nums[nums.length - 1] >= mid){
                    //search front
                    return search(Arrays.copyOfRange(nums, 0, midIndex), target, acc);
                }
                else{
                    //search back
                    return search(Arrays.copyOfRange(nums, midIndex + 1, nums.length), target, acc + midIndex + 1);
                }
            }
            else if(mid < target){
                if(nums[nums.length - 1] >= target || nums[0] <= mid){
                    //search back
                    return search(Arrays.copyOfRange(nums, midIndex + 1, nums.length), target, acc + midIndex + 1);
                }
                else{
                    //search front
                    return search(Arrays.copyOfRange(nums, 0, midIndex), target, acc); 
                
            }
        }
        return -1; 
    }
}
}