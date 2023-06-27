// Brutal force, works, but Timeout

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0; 
//         for(int i=0; i<s.length(); i++){
//             for(int j=i+1; j<s.length()+1; j++){
//                 String sub = s.substring(i, j); 
//                 if(sub.length() == sub.chars().distinct().count() && sub.length() > max){
//                     max = sub.length(); 
//                 }
//             }
//         }
//         return max; 
//     }
// }

//9% 15%
//sliding
//Time O(n^2) 
//space O(n)

// class Solution {
//     public static int lengthOfLongestSubstring(String s) {
//         int i = 0;
//         int j = 0;  
//         String sub; 
//         int max = 0; 
//         while(j < s.length()+1){
//             sub = s.substring(i, j);
//             System.out.println(": " + sub); 
//             max = (sub.length() > max) ? sub.length() : max; 
//             if(j < s.length() && sub.indexOf(s.charAt(j)) != -1){
//                 int off = sub.indexOf(s.charAt(j));
//                 i = i + 1 + off;
//                 j++; 
//             }
//             else{
//                 j++;
//             }
//         }
//         return max; 
//     }

//     public static void main(String[] args){
//         String s = " "; 
//         System.out.println(lengthOfLongestSubstring(s));
//     }
// }

//sliding with hashmap
// 35 % 70%
//Time O(n+n)
//space O(n)
import java.util.HashMap;
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); 
        int i = 0;
        int j = 0;  
        int max = 0; 
        while(j < s.length()+1){
            //sub = s.substring(i, j);
            max = ((j-i) > max) ? (j-i) : max; 
            if(j < s.length()){
                char test = s.charAt(j);
                hm.put(test, hm.getOrDefault(test, 0)+1); //increase count
                while(hm.get(test) > 1){
                    hm.put(s.charAt(i), hm.get(s.charAt(i))-1); 
                    i++; 
                }
            }
            j++; 
        }
        return max; 
    }

    public static void main(String[] args){
        String s = "a"; 
        System.out.println(lengthOfLongestSubstring(s));
    }
}