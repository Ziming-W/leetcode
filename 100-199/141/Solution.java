/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*; 

 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false; 
        }
        HashSet<ListNode> hs = new HashSet<>(); 
        while(head.next != null){
            if(hs.contains(head)){
                return true; 
            }
            else{
                hs.add(head); 
                head = head.next; 
            }
        }

        return false; 
    }
}