import java.util.*; 

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>(); 
        int max = 0; 
        int left = -1; 
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i); 
            }
            else{
                if(stack.isEmpty()){
                   left = i; 
                }
                else{
                    stack.pop();
                    //sum here
                    if(stack.isEmpty()){
                        max = Math.max(max, i - left); 
                    }
                    //else, keep counting
                    else{
                        max = Math.max(max, i - stack.peek()); 
                    }
                }
            }
        }
        return max; 

    }

   

}
