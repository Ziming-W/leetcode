import java.util.*; 

//Time ?
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>(); 
        }
        HashMap<Integer, char[]> hm = new HashMap<>(); 
        int inc = 95; 
        for(int i = 2; i < 10; i++){
            if( i == 7 || i == 9){
                hm.put(i, new char[]{(char)(i+inc),(char)(i+inc+1), (char)(i+inc+2), (char)(i+inc+3)});
                inc += 3;  
            }
            else{
                hm.put(i, new char[]{(char)(i+inc),(char)(i+inc+1), (char)(i+inc+2)}); 
                inc += 2;  
            }
        }
        //System.out.println(hm); 
        List<String> store = new ArrayList<>();
        store.add("");  
        for(char digit:digits.toCharArray()){
            if(digit == '1'){
                continue; 
            }
            //new store
            List<String> newStore = new ArrayList(); 
            for(char ch:hm.get(Character.getNumericValue(digit))){
                //copy over old list, add new char to the end of each String
                List<String> newCombo = new ArrayList<>(); 
                for(String str:store){
                    newCombo.add(str + ch); 
                }
                //apppend new list to the end of old list
                for(String str:newCombo){
                    newStore.add(str); 
                }
            }
            store = newStore; 
        }
        return store; 
    }
}
