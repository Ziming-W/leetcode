
import java.util.*; 


class Solution {
    public int longestSubstring(String s, int k) {
        int l, r; 
        l = r = 0;

        int len = s.length(); 
        HashMap<Character, Integer> hm = new HashMap<>(); 

        int maxLen = 0; 
        boolean flag = false; 
        while(r < len){
            char c = s.charAt(0); 
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            if(hm.get(c) >= k){
                flag = true; 
            }
            if(flag)

        }


        
    }
}