/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }

        ListNode slowPrev = null; 
        ListNode slow = head; 
        ListNode fast = head; 

        while(fast != null){
            if(fast.next != null){
                fast = fast.next; 
            }
            else{
                break; 
            }
            slowPrev = slow;
            slow = slow.next; 
            if(fast.next != null){
                fast = fast.next; 
            }
            else{
                break; 
            }
        }

        if(slow == head){
            return null;  
        }
        else{
            slowPrev.next = slow.next; 
        }
        return head; 
    }
}
