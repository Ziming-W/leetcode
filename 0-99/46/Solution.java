// import java.util.*; 
// class Solution {
//     public static List<List<Integer>> permute(int[] nums) { 
//         List<List<Integer>> pool = new ArrayList<>();
//         pool.add(new ArrayList<>()); 
//         for(int i = 0; i < nums.length; i++){
//             List<Integer> copyCandidates = new ArrayList<>(); 
//             for(int j = 0; j < nums.length; j++){
//                 if(j != i){
//                     copyCandidates.add(nums[j]); 
//                 }
//             }
//             place(pool, copyCandidates); 
//         }
//         return pool; 
//     }

//     private static void place(List<List<Integer>> pool, List<Integer> candidates){
//         List<List<Integer>> newPool = new ArrayList<>(); 
//         for(int candidate:candidates){
//             for(List<Integer> permu:pool){
//                 List<Integer> permuCopy = new ArrayList<>();
//                 //copy existing elements
//                 for(int p:permu){
//                     permuCopy.add(p); 
//                 }
//                 //add new 
//                 permuCopy.add(candidate);
//                 newPool.add(permuCopy); 
//             }
//         }
//         pool = newPool; 
//     }

//     public static void main(String[] args){
//         System.out.println(permute(new int[]{1, 2, 3})); 
//     }
// }



//backtracking
import java.util.*;


class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>(); 
        List<Integer> incompleteList = new ArrayList<>(); 
        //search optimization
        HashSet<Integer> hs = new HashSet<>(); 
        backTrack(permutes, incompleteList, hs, nums);
        return permutes; 
    }

    public static void backTrack(List<List<Integer>> permutes, List<Integer> incompleteList, HashSet<Integer> hs, int[] nums){
        if(incompleteList.size() == nums.length){
            List<Integer> completeList = new ArrayList<>(); 
            completeList.addAll(incompleteList); 
            permutes.add(completeList); 
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(hs.contains(nums[i])){
                    continue; 
                }
                else{
                    incompleteList.add(nums[i]); 
                    hs.add(nums[i]); 
                    backTrack(permutes, incompleteList, hs, nums);
                    hs.remove(incompleteList.get(incompleteList.size() - 1)); 
                    incompleteList.remove(incompleteList.size() - 1); 
                }
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> lst; 
        lst = permute(new int[]{1, 2, 3}); 
        for(int i = 0; i < lst.size(); i++){
            for(int j = 0; j < lst.get(0).size(); j++){
                System.out.print(lst.get(i).get(j) + " "); 
            }
            System.out.println(); 
        }
    }
}


