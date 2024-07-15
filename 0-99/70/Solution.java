import java.util.*; 

class Solution {
    public int climbStairs(int n) {
        List<Integer> store = new ArrayList<>(); 
        for(int i = 1; i <= n; i++){
            if(i == 1){
                store.add(1); 
            }
            else if(i == 2){
                store.add(2); 
            }
            else{
                store.add(store.get(store.size()-1) + store.get(store.size()-2)); 
            }
        }

        return store.get(store.size()-1); 
        
    }
}


// 1 2 3 5 8 13
