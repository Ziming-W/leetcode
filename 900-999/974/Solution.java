import java.util.*;
import java.util.stream.Collectors; 

//TLE
// class Solution {
//     public static int subarraysDivByK(int[] nums, int k) {
//         int counter = 0; 
//         int sum = 0; 
//         boolean reverse = false; 
//         for(int i = 0; i < nums.length; i++){
//             if(reverse){
//                 sum -= nums[i-1];
//                 for(int j = nums.length-1; j >= i; j--){
//                     if(sum % k == 0){
//                         counter++;  
//                     }
//                     sum -= nums[j];
//                 }   
//             }
//             else{
//                 for(int j = i; j < nums.length; j++){
//                     sum += nums[j]; 
//                     if(sum % k == 0){
//                         counter++;  
//                     }
//                 }
//             }
            
//             reverse = !reverse; 
//         }

//         return counter; 
//     }


//     public static void main(String[] args){
//         System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5)); 
//     }
// }


class Solution {
    public static long kSub(int k, List<Integer> nums) {
        List<Integer> prefixSum = new ArrayList<>(); 
        int sum = 0; 
        long counter = 0; 
        prefixSum.add(0); 
        for(int i = 0; i < nums.size(); i++){
            sum += nums.get(i); 
            prefixSum.add(sum); 
        }
        for(int i = 0; i < nums.size() + 1; i++){
            for(int j = i + 1; j < nums.size() + 1; j++){
                if((prefixSum.get(j) - prefixSum.get(i)) %k == 0){
                    //System.out.println(i + " " + j); 
                    counter++; 
                }
            }
        }
        return counter; 
    }


    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3, 4, 1}; 
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
         System.out.println(kSub(3, list)); 
     }
}