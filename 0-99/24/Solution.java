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
import java.util.*; 

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head; 
        }
        ListNode dummyHead = new ListNode(); 
        dummyHead.next = head; 
        ListNode prevEnd = dummyHead; 
        ListNode fst = head; 
        ListNode snd = head.next;
        while(fst != null){
            if(snd == null){
                prevEnd.next = fst; 
                //fst.next = null; 
                break; 
            }
            ListNode nextStart = snd.next; 
            prevEnd.next = snd; 
            snd.next = fst; 
            prevEnd = fst; 
            //fst = nextStart; 
            if(nextStart == null){
                fst.next = null; 
                break; 
            }
            fst = nextStart; 
            snd = fst.next; 
        }
        return dummyHead.next; 
    }
}
