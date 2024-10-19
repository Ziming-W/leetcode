class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0; 
        int left = 0; 
        int zeroCounter = 0; 
        int max = 0; 
        while(right < nums.length){
            if(nums[right] == 1){
                max = Math.max((right - left + 1), max); 
            }
            else{
                if(zeroCounter < k){
                    zeroCounter ++; 
                    max = Math.max((right - left + 1), max); 
                }
                else{
                    // remove one more zero
                    while(nums[left] != 0){
                        left++; 
                    }
                    left++; 
                    max = Math.max((right - left + 1), max); 
                }
            }
            right++;    
        }

        return max;
        
    }
}
