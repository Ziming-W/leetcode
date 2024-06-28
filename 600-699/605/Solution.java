class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean prevPlant = false; 
        int counter = 0; 
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1){
                prevPlant = true; 
            }
            else{
                if(prevPlant){
                    prevPlant = false; 
                }
                else{
                    if( (i <= flowerbed.length-2 && flowerbed[i+1]!= 1)  || (i>flowerbed.length-2)){
                        System.out.println("plant at" + " " + i); 
                        prevPlant = true; 
                        counter++; 
                        if(counter >= n){
                            return true; 
                        }
                    }

                }
            }
        }

        if(counter >= n){
            return true; 
        }
        return false; 


    }
}