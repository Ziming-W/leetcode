import java.util.*; 

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length; 
        List<Integer> output = new ArrayList<>(); 
        List<Integer> rightStack = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            if(asteroids[i] > 0){
                rightStack.add(asteroids[i]); 
            }
            else{
                if(rightStack.size() == 0){
                    output.add(asteroids[i]); 
                }
                else{
                    boolean candidateSurvive = true; 
                    while(rightStack.size() > 0){
                        if(Math.abs(asteroids[i]) > Math.abs(rightStack.get(rightStack.size()-1))){
                            rightStack.remove(rightStack.size()-1); 
                        }
                        else if(Math.abs(asteroids[i]) == Math.abs(rightStack.get(rightStack.size()-1))){
                            rightStack.remove(rightStack.size() -1); 
                            candidateSurvive = false; 
                            break; 
                        }
                        else{
                            candidateSurvive = false; 
                            break; 
                        }
                    }
                    if(candidateSurvive && rightStack.size() == 0){
                        output.add(asteroids[i]); 
                    }
                }
            }
        }
        for(int i = 0; i < rightStack.size(); i++){
            output.add(rightStack.get(i)); 
        }

        int[] outputArray = new int[output.size()]; 
        for(int i = 0; i < output.size(); i++){
            outputArray[i] = output.get(i); 
        }
        return outputArray; 
    }
}