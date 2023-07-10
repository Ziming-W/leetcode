import java.util.*; 

class Solution {
    public static  List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>(); 
        HashMap<String, List<Integer>> hm = new HashMap<>(); 
        List<String> store = new ArrayList<>(); 
        for(int i = 0; i < strs.length; i++){
            char[] chs = strs[i].toCharArray(); 
            Arrays.sort(chs); 
            store.add(new String(chs)); 
        }

        for(int i = 0; i < store.size(); i++){
            String str = store.get(i); 
            if(!hm.containsKey(str)){
                hm.put(str, new ArrayList<>(Arrays.asList(i))); 
            }
            else{
                hm.get(str).add(i); 
            }
        }

        for(List<Integer> lst:hm.values()){
            List<String> tempLst = new ArrayList<>(); 
            for(int i:lst){
                tempLst.add(strs[i]); 
            }
            output.add(tempLst); 
        }
        return output; 
    }
}