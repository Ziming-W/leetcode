class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1; 
        }
        int left = 0; 
        int right = 1; 
        while(right < nums.length){
            if(nums[right] == nums[left]){
                right ++; 
            }
            else{
                nums[left+1] = nums[right]; 
                left ++; 
                right ++; 
            }
            System.out.println(Arrays.toString(nums));
        }

        return left + 1; 
        
    }
}
