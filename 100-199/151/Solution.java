import java.util.*; 

class Solution {
    public String reverseWords(String s) {
        List<String> result = new ArrayList<>(); 
        StringBuilder sb = new StringBuilder(); 
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(sb.length() > 0){
                    result.add(0, sb.toString()); 
                    sb = new StringBuilder(); 
                }
            }
            else{
                sb.append(s.charAt(i)); 
            }
        }

        if(sb.length() > 0){result.add(0, sb.toString()); }

        StringBuilder resultSb = new StringBuilder(); 
        for(int i = 0; i < result.size(); i++){
            resultSb.append(result.get(i)); 
            resultSb.append((i==result.size()-1) ? "" : ' '); 
        }
        return resultSb.toString(); 
    }
}
