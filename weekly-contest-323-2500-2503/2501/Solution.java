import java.util.*; 
class Solution {
    public static int longestSquareStreak(int[] nums) {
        int maxLen = -1; 
        Arrays.sort(nums); 
        HashMap<Integer, Integer> hm = new HashMap<>();
        boolean[] visited = new boolean[nums.length]; //don't visit exist square twice 
        for(int i = 0; i < nums.length; i++){
            visited[i] = false;  
        }
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1); 
        }
        for(int i = 0; i < nums.length; i++){
            //prevent integer overflow
            if(visited[i] || nums[i] > 46340){
                continue; 
            }
            visited[i] = true; 
            int currLen = 1; 
            int square = nums[i]*nums[i]; 
            while(hm.getOrDefault(square, 0) != 0){
                if(square > 46340){
                    currLen++; 
                    break; 
                }
                currLen++; 
                square *= square; 
            }
            maxLen = (currLen > maxLen && currLen > 1) ? currLen : maxLen; 
        }
        return maxLen; 
    }
}
