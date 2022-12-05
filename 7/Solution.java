//overflow, doesn't work
class Solution {
    public int reverse(int x) {
        int sign = 1; 
        int acc = 0; 
        int mul = 1; 
        if(x < 0){
            x = -x; 
            sign = -1; 
        }
        char[] ch = Integer.toString(x).toCharArray(); 
        for(int i = 0; i<ch.length; i++){
            acc += mul*Character.getNumericValue(ch[i]); 
            mul *= 10; 
            if(acc > Integer.MAX_VALUE){
                return 0; 
            }
        }
        return sign*acc; 
    }
}