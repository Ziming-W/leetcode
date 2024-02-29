class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length; 
        int[] productL = new int[len]; 
        int[] productR = new int[len]; 
        int accL = 1; 
        int accR = 1; 
        for(int i = 0; i < len; i++){
            productL[i] = accL; 
            accL *= nums[i]; 
            productR[len-i-1] = accR; 
            accR *= nums[len-i-1]; 
        }
        int[] result = new int[len]; 
        for(int i = 0; i < len; i++){
            result[i] = productL[i] * productR[i]; 
        }
        return result; 
    }
}
