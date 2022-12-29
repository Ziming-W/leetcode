import java.util.*; 
class Solution {
    public void nextPermutation(int[] nums) {
        int[] sorted = new int[nums.length]; 
        for(int i = 0; i < nums.length; i++){
            sorted[i] = nums[i]; 
        }
        Arrays.sort(sorted); 
        if(nums.length == 1){
            return; 
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                int[] front = Arrays.copyOfRange(nums, 0, i); 
                int[] back = Arrays.copyOfRange(nums, i + 1, nums.length); 
                int[] sortedBack = new int[back.length]; 
                for(int x = 0; x < back.length; x++){
                    
                }
                for(int j = 0; j < nums.length - 1; j++){
                    if(sorted[j] == nums[i+1] && sorted[j+1] > nums[i+1]){

                    }
                }
            }
        } 



    }
}
