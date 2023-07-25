import java.util.*; 

class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length; 
        Arrays.sort(nums);
        return Math.max(nums[len-1]*nums[len-2]*nums[len-3], nums[len-1]*nums[1]*nums[0]); 
    }
}