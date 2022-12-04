//99% 89%

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0); 
        ListNode curr = start; 
        int inc = 0; 
        while(l1 != null || l2 != null || inc == 1){
            int sum = 0; 
            if(l1 != null){
                sum += l1.val; 
                l1 = l1.next; 
            }
            if(l2 != null){
                sum += l2.val; 
                l2 = l2.next; 
            }
            sum += inc; 
            if(sum >= 10){
                inc = 1; 
                sum = sum % 10; 
            }
            else{
                inc = 0; 
            }
            ListNode newNode = new ListNode(sum); 
            curr.next = newNode; 
            curr = newNode; 
        }
        return start.next; 
    }
}