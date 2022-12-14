import java.util.*;

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         if(n == 1){
//             return Arrays.asList("()"); 
//         }
//         List<String> lastStepList = generateParenthesis(n-1);
//         List<String> currList = new ArrayList<>(); 
//         for(String str:lastStepList){
//             currList.add('(' + str + ')');  //wrap everything brackets
//             currList.add("()" + str); //left empty brackets
//             currList.add(str + "()"); //right empty brackets
//             //inside a bracket 
//             for(int i = 0; i < str.length()-1; i++){
//                 if(str.charAt(i) == '(' && str.charAt(i + 1) == ')'){
//                     String newStr = str.substring(0, i+1) + "()" + str.substring(i+1, str.length());
//                     //System.out.println(str + i + "  " + newStr);  
//                     currList.add(newStr); 
//                 }
//             }
//         }
//         //remove dup
//         HashMap<String, Integer> hm = new HashMap<>(); 
//         for(String str:currList){
//             hm.put(str, hm.getOrDefault(str, 0)+1);  
//         }
//         return new ArrayList<String>(hm.keySet()); 
//     }
// }

//own dp 
//Time O()
class Solution {
    private HashMap<Integer, List<String>> hm = new HashMap<>(); 

    public Solution(){
        hm.put(1, Arrays.asList("()")); 
        hm.put(2, Arrays.asList("()()", "(())")); 
    }

    public List<String> generateParenthesis(int n) {
        if (hm.containsKey(n)) {
            return hm.get(n); 
        }
        else {
            List<String> currList = new ArrayList<>();
            for(int i = 1; i < n/2+1; i++){
                List<String> l1 = generateParenthesis(i);
                List<String> l2 = generateParenthesis(n - i);
                List<String> l3 = generateParenthesis(n - 1);
                for (String str1 : l1) {
                    for (String str2 : l2) {
                        currList.add(str1 + str2);
                        currList.add(str2 + str1);
                    }
                }
                for(String str3:l3){
                    currList.add("(" + str3 + ")"); 
                }
            }
            HashMap<String, Integer> tempHm = new HashMap<>(); 
            for(String str:currList){
                tempHm.put(str, tempHm.getOrDefault(str, 0) + 1); 
            }
            currList = new ArrayList<String>(tempHm.keySet()); 
            hm.put(n, currList); 
            return currList;
        }
    }
}

