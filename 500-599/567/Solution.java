import java.util.*;
// should have used HashMap instead of ArrayList
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int r = 0; 
        int len = s2.length(); 

        ArrayList<Character> list = new ArrayList<>(); 
        renewList(s1, list);

        while(r < len){
            // move right
            if(list.contains(s2.charAt(r))){
                list.remove(list.indexOf(s2.charAt(r))); 
                r++; 
                if(list.isEmpty()){
                    return true; 
                }
            }
            else{
                // move left, we can still re-use
                if(s1.contains(Character.toString(s2.charAt(r)))){
                    for(int i = r-(s1.length()-list.size()); i < r; i++){
                        list.add(s2.charAt(i)); 
                        if(s2.charAt(i) == s2.charAt(r)){
                            break; 
                        }
                    }
                    list.remove(list.indexOf(s2.charAt(r))); 
                }
                // start all over, we can't make up on this
                else{
                    renewList(s1, list);
                }
                r++; 
            }
        }

        return false; 
    }

    public void renewList(String s, ArrayList<Character> list){
        list.clear();
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i)); 
        }
    }
}