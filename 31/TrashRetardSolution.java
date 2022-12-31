import java.util.*; 
//retard stuff
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return; 
        }
        if(nums.length == 2){
            int temp = nums[0]; 
            nums[0] = nums[1]; 
            nums[1] = temp; 
            return; 
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                if(i == 0){
                    int last = nums[1]; 
                    List<Integer> backList = new ArrayList<Integer>();
                    for(int elem:Arrays.copyOfRange(nums, i+1, nums.length)){
                        backList.add(elem); 
                    }
                    Collections.sort(backList);
                    //check desce
                        
                    int index = backList.indexOf(last); 
                    int large = backList.remove(index + 1); 
                    nums[1] = large; 
                    int currOutputIndex = 2; 
                    for(int j = 0; j < backList.size(); j++){
                        nums[currOutputIndex ++] = backList.get(j); 
                    }
                    return; 
                }
                else{
                    int last = nums[i-1]; 
                    int[] front = Arrays.copyOfRange(nums, 0, i - 1); 
                    int[] back = Arrays.copyOfRange(nums, i - 1, nums.length);
                    List<Integer> backList = new ArrayList<Integer>(); 
                    for(int elem:back){
                        backList.add(elem); 
                    }
                    Collections.sort(backList); 
                    int index = 0; 
                    for(int x = 0; x < backList.size(); x++){
                        if(backList.get(x) == last){
                            index = x; 
                        }
                    }
                    //test if desce
                    if(index == (backList.size() - 1)){
                        break; 
                    } 
                    int large = backList.remove(index + 1); 
                    int currOutputIndex = 0; 
                    //add front
                    if(front.length > 0){
                        for(int j = 0; j < front.length; j++){
                            nums[currOutputIndex++] = front[j]; 
                        }
                    }
                    //add large
                    nums[currOutputIndex++] = large; 
                    //add rest sorted back
                    for(int j = 0; j < backList.size(); j++){
                        nums[currOutputIndex++] = backList.get(j); 
                    }
                    return; 
                }
            }
        }
        //if sorted in asce already
        int index = 1; 
        while(index < nums.length && nums[index] == nums[0]){
            index++; 
        }
        if(nums[0] < nums[index]){
            //swap largest and second largest
            List<Integer> store = new ArrayList<Integer>(); 
            for(int elem:nums){
                store.add(elem); 
            }
            int largest = Collections.max(store); 
            int firstIndex = store.indexOf(largest); 
            store.removeAll(Arrays.asList(Collections.max(store)));
            int secondIndex = store.size() - 1; 
            int temp = nums[secondIndex]; 
            nums[secondIndex] = nums[firstIndex]; 
            nums[firstIndex] = temp; 
        }
        //sorted in desce
        else{
            int[] dup = Arrays.copyOf(nums, nums.length); 
            for(int i = 0; i < nums.length; i++){
                nums[i] = dup[nums.length - i - 1]; 
            }
        }
    }
}
