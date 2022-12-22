class Allocator {

    private int[] store; 

    public Allocator(int n) {
        store = new int[n]; 
        for(int i = 0; i < n; i++){
            store[i] = -1; 
        }
    }
    
    public int allocate(int size, int mID) {
        //System.out.println(Arrays.toString(store)); 
        for(int i = 0; i < (store.length - size + 1); i++){
            //System.out.println(i); 
            Boolean freeHere = true; 
            for(int j = 0; j < size && (i+j)<store.length; j++){
                if(store[i+j] != -1){
                    freeHere = false; 
                    break; 
                }
            }
            if((i + size) > store.length){
                return -1; 
            }
            if (freeHere) {
                for (int k = i; k < i + size; k++) {
                    store[k] = mID;
                }
                return i;
            }
        }
        return -1; 
    }
    
    public int free(int mID) {
        //System.out.println(Arrays.toString(store)); 
        int counter = 0; 
        for(int i = 0; i < store.length; i++){
            if(store[i] == mID){
                store[i] = -1;
                counter ++; 
            }
        }
        return counter; 
    }
}
