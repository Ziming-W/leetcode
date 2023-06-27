class Solution {
    public int jump(int[] nums) {
        int at = 0; 
        int len = nums.length;
        int jumpCount = 0; 
        while(at < len){
            int jump = nums[at]; 
            //if can reach end in a jump
            if(at + jump >= len){
                return (jumpCount + 1); 
            }
            //iterate candidate to jump
            int longestJump = at + jump; 
            int candidate = at; 
            for(int i = at; i < at + jump; i++){
                int currJump = i + nums[i]; 
                if(currJump > longestJump){
                    longestJump = currJump; 
                    candidate = i; 
                }
            }

            //jump

        }
    }
}