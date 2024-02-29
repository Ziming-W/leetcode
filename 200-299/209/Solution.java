class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length; 
        int left = 0; 
        int right = 0; 
        int minWin = Integer.MAX_VALUE; 
        int sum = nums[0]; 
        while(true){
            if(sum >= target && left == right){
                return 1; 
            }
            if(right == (len-1) && sum < target){
                break; 
            }
            if(sum >= target){
                minWin = Math.min(minWin, right-left + 1); 
                System.out.println("" + minWin + left + right); 
                sum -= nums[left]; 
                left++; 
            }
            else{
                right ++; 
                sum += nums[right]; 
            }
                      
    }
    if(minWin == Integer.MAX_VALUE){
        return 0; 
    }
    else{
        return minWin; 
    }
}
}