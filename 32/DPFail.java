import java.util.*; 

class Solution {
    public int longestValidParentheses(String s) {

    }

    public int recSolve(String s, int stackSize, int localAcc){
        if(s.length() == 0){
            return localAcc; 
        }
        else if(s.length() == 1){
            if(s.charAt(0) == ')'){
                return (stackSize >= 1) ? localAcc + 2 : localAcc; 
            }
            else{
                return localAcc; 
            }
        }
        else{
            if(s.charAt(0) == '('){
                return recSolve(s.substring(1, s.length()), stackSize + 1, localAcc); 
            }
            else{
                if(stackSize >= 1){
                    return recSolve(s.substring(1, s.length()), stackSize - 1, localAcc + 2); 
                }
                else{
                    int nextAcc = recSolve(s.substring(1, s.length()), 0, 0); 
                    return localAcc > nextAcc ? localAcc : nextAcc;           
                }
            }
        }
    }

}
