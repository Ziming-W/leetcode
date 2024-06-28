/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> store = new ArrayList<>(); 
        rec(store, root, true, 0);

    }

    private void rec(ArrayList<ArrayList<Integer>> store, TreeNode node, boolean newSubList, int counter){
        if(node == null){
            return ; 
        }
        int newCounter = counter; 

        if(newSubList){
            store.add(new ArrayList<>(Arrays.asList(node.val))); 
            newCounter ++; 
        }
        else{
            store.get(counter).add(node.val); 
        }

        if(node.left != null && node.right == null){
            rec(store, node.left, true, newCounter); 
        }
        else if(node.left != null && node.right != null){
            rec(store, node.left, true, newCounter); 
            rec(store, node.right, false, newCounter); 
        }
    }
}