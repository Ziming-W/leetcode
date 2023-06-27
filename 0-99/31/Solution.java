class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1; 
        while(i > 0){
            if(nums[i] > nums[i - 1]){
                break; 
            }
            i--; 
        }
        //if desce
        if(i == 0){
            reverse(nums, 0, nums.length - 1);
            return;  
        }
        int j = nums.length - 1; 
        while(j >= i){
            if(nums[j] > nums[i - 1]){
                swap(nums, i - 1, j); 
                break; 
            }
            j--; 
        }
        reverse(nums, i, nums.length - 1); 
    
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public void reverse(int[] A, int start, int end) {
        while(start < end) swap(A, start++, end--);
    }
}
