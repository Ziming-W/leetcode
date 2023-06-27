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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyStartOdd = new ListNode(); 
        ListNode currOdd = dummyStartOdd; 
        ListNode dummyStartEven = new ListNode(); 
        ListNode currEven = dummyStartEven; 
        boolean odd = true; 
        while(head != null){
            if(odd){
                currOdd.next = head; 
                currOdd = currOdd.next; 
                odd = false; 
            }
            else{
                currEven.next = head; 
                currEven = currEven.next; 
                odd = true; 
            }
            head = head.next; 
        }
        currEven.next = null; 
        currOdd.next = dummyStartEven.next; 
        return dummyStartOdd.next; 
    }
}