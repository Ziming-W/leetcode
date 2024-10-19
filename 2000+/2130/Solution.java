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
    public int pairSum(ListNode head) {

        // firstly, find the middle
        ListNode slow = head; 
        ListNode fast = head; 

        while(fast.next != null){
            fast = fast.next; 
            slow = slow.next; 
            if(fast.next != null){
                fast = fast.next; 
            }
            else{
                break; 
            }
        }

        // slow is the begining of the second half
        // reverse it 
        ListNode prev = null; 
        ListNode curr = slow; 
        ListNode next = null; 
        while(curr != null){
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }

        System.out.print(prev.val); 

        // curr is the start of the next reversed list
        int max = 0; 
        while(prev != null && head != null){
            max = Math.max(max, prev.val + head.val); 
            prev = prev.next; 
            head = head.next; 
        }

        return max; 
    }
}