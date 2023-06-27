class Solution {
    public int maxArea(int[] height) {
        int i = 0; 
        int j = height.length - 1; 
        int max = 0; 
        while(i < j){
            int curr = (j - i) * (Integer.min(height[i], height[j])); 
            max = (curr > max) ? curr : max;
            if(height[i] <= height[j]){
                i++; 
            } 
            else{
                j--; 
            }
        }
        return max; 
    }
}