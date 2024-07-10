class Solution {
    public int maxArea(int[] height) {
        int high = 0; 
        int low = height.length-1; 
        int maxVolumn = Integer.MIN_VALUE;

        while(high != low){
            if(height[high] < height[low]){
                int temp = high; 
                high = low; 
                low = temp;
            }
            System.out.println(low + " " + high); 
            maxVolumn = Math.max(maxVolumn, Math.abs(high-low)*height[low]); 
            if(high > low){
                low++; 
            }
            else{
                low--; 
            }

        }

        return maxVolumn; 
    }
}