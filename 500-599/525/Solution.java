class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length; 
        int left = 0; 
        int right = 0; 
        int zeroCount = 0;
        int oneCount = 0;
        while(right < len){
            if(nums[right] == 0){
                zeroCount ++; 
            }
            else{
                oneCount++; 
            }
            while(left < right){
                if(zeroCount == oneCount){
                    break; 
                }
                else{
                    if(left == 0){
                        zeroCount --; 
                    }
                    else{
                        oneCount--; 
                    }
                    left++; 
                }
            }

            right++; 

        }
        
    }
}