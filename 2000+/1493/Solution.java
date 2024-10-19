class Solution {
    public int longestSubarray(int[] nums) {
        int right = 0; 
        int left = 0; 
        int max = 0; 
        int counter = 0; 
        int numZeroCounter = 0; 

        while(right < nums.length){
            if(nums[right] == 1){
                counter ++; 
                max = Math.max(max, counter); 
            }
            else{
                if(numZeroCounter == 1){
                    while(nums[left] != 0){
                        counter--; 
                        left++; 
                    }
                    left++; 
                }
                else{
                    numZeroCounter ++; 
                }
            }
            right++; 
        }

        if(numZeroCounter == 0){
            return max-1;
        }
        else{
            return max; 
        }
    }
}

// 110110