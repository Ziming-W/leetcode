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

//two pass
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         int len = 0; 
//         ListNode curr = head; 
//         while(curr != null){
//             len++; 
//             curr = curr.next; 
//         }
//         curr = head; 
//         ListNode prev = head; 
//         if(len == n){
//             return head.next; 
//         }
//         len -= n; 
//         while(curr != null){
//             if(len == 0){
//                 prev.next = curr.next; 
//                 return head; 
//             }
//             len--; 
//             prev = curr; 
//             curr = curr.next; 
//         }
//         return head; 
//     }
// }

//one pass
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        boolean moveBoth = false; 
        int gap = 0; 
        ListNode delete = head; 
        ListNode deletePrev = head; 
        ListNode search = head; 
        while(search != null){
            //if gap between delete node and search node equals to n, 
            //we move both search node and delete node forward
            if(gap == n){
                moveBoth = true; 
            }
            if(moveBoth){
                //move delete node forward
                deletePrev = delete; 
                delete = delete.next; 
            }
            search = search.next; //move search node forward
            gap++;
        }
        //if the node to be deleted is the head, return next node directly
        if(delete == head){
            return head.next; 
        }
        //if the node to be deleted is not the head, we can delete this one safely and return head
        deletePrev.next = delete.next; 
        return head; 
    }
}


