class Solution {
    public static int myAtoi(String s) {
        int acc = 0, sign = 1; 
        //step 1
        s = s.trim(); 
        if(s.length() == 0){
            return 0; 
        }
        //step 2
        if(s.charAt(0) == '-'){
            sign = -1;
            s = s.substring(1, s.length());  
        }
        else if(s.charAt(0) == '+'){
            s = s.substring(1, s.length()); 
        }
        //step 3
        for(int i = 0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                break; 
            }
            int num = Character.getNumericValue(s.charAt(i));
            //check if overflow
            // if(((acc - sign*num) / 10) != prevAcc){
            //     return ((sign > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE); 
            // }
            if(acc > Integer.MAX_VALUE/10 || (acc == Integer.MAX_VALUE/10 && num > 7)){
                return (sign > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } 
            acc = acc*10 + num; 
        }
        return acc*sign; 
    }

    public static void main(String[] args){
        String s = "2147483648"; 
        System.out.println(myAtoi(s));
    }

}