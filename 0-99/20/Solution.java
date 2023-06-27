//any close order doesn't have to be next to each other
import java.util.*; 
// class Solution {
//     public boolean isValid(String s) {
//         int parCount = 0; 
//         int squareCount = 0; 
//         int curlyCount = 0; 
//         for(char ch:s.toCharArray()){
//             if(ch == '('){
//                 parCount++; 
//             }
//             else if(ch == ')'){
//                 parCount--;
//             }
//             else if(ch == '['){
//                 squareCount++; 
//             }
//             else if(ch == ']'){
//                 squareCount--; 
//             }
//             else if(ch == '{'){
//                 curlyCount++; 
//             }
//             else if(ch == '}'){
//                 curlyCount--; 
//             }
//             if(parCount < 0 || squareCount < 0 || curlyCount < 0){
//                 return false; 
//             }
//         }
//         return (parCount == 0) && (squareCount == 0) && (curlyCount == 0); 
//     }
// }

//complex becase written for future harder question purpose
class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>(); 
        for(char ch:s.toCharArray()){
            //if("({[".indexOf(Character.toString(ch)) != -1){
            //if(Arrays.asList('(', '[', '{').contains(ch)){
            if(Arrays.asList(new Character[]{'[', '(', '{'}).contains(ch)){
                stack.add(ch); 
            }
            else{
                if(stack.size() == 0){
                    return false; 
                }
                char pop = stack.remove(stack.size()-1);
                if( !((ch == '}' && pop == '{') || (ch == ']' && pop == '[') || (ch == ')' && pop == '('))){
                    return false; 
                }
            }
        }
        if(stack.size() == 0){
            return true; 
        }
        else{
            return false; 
        }
    }
}