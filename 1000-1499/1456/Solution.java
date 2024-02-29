class Solution {
    // simple sliding windows
    public int maxVowels(String s, int k) {
        int len = s.length(); 
        int max = Integer.MIN_VALUE; 
        int counter = 0; 
        for(int i = 0; i < k; i++){
            if("aeiou".indexOf(s.charAt(i)) != -1){
                counter ++; 
            }
        }
        max = Math.max(counter, max); 
        boolean lastVowel = ("aeiou".indexOf(s.charAt(0)) != -1); 
        for(int i = 1; i <= len-k; i++){
            if(lastVowel){
                counter --; 
            }
            if("aeiou".indexOf(s.charAt(i+k-1)) != -1){
                counter ++; 
            }
            max = Math.max(max, counter); 
            lastVowel = ("aeiou".indexOf(s.charAt(i)) != -1); 
        }
        return max;
    }
}
