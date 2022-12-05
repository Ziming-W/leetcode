//DP
class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length(); 
        boolean[][] matrix = new boolean[len][len]; 
        char [] ch = s.toCharArray(); 
        int maxI = 0; 
        int maxJ = 0; 
        int maxLen = 0; 
        for(int i = 0; i < len; i++){ //column index
            for(int j = i; j >= 0; j--){ //row index
                if(j == i){
                    matrix[j][i] = true; 
                }
                else if(i == (j + 1)){
                    matrix[j][i] = (ch[j] == ch[i]); 
                }
                else{
                   matrix[j][i] = (matrix[j+1][i-1] && ch[i] == ch[i-(Math.abs((j+1)-(i-1)) + 2)]); 
                }
                //update length and keep track of index
                if(matrix[j][i]){
                    if((i-j) > maxLen){
                        maxLen = i - j; 
                        maxI = i; 
                        maxJ = j; 
                    }
                }
            }
        }
        return s.substring(maxJ, maxI+1); 
    }

    public static void main(String[] args){
        String s = "cbbd"; 
        System.out.println(longestPalindrome(s)); 
    }
}