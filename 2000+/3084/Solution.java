class Solution {
    public long countSubstrings(String s, char c) {
        long counter = 0; 
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                counter++;
            }
        }

        return ((counter * (counter - 1) / 2) + counter); 

        
    }
}