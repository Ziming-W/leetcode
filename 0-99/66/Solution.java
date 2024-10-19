class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        for(int i = len-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] =  digits[i] + 1; 
                carry = 0; 
                break; 
            }
            else{
                digits[i] = 0; 
            }
        }

        int[] result; 

        if(carry == 1){
            result = new int[len+1]; 
            result[0] = 1;
            for(int i = 0; i < len; i++){
                result[i+1] = digits[i]; 
            }
        }
        else{
            result = digits; 
        }

        return result; 
        
    }
}