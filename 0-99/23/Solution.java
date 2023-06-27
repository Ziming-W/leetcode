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

//simple merge sort 
import java.util.*; 

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null; 
        }
        else if(lists.length == 1){
            return lists[0]; 
        }
        else{
            //divide to two parts
            ListNode[] myArray1 = Arrays.copyOfRange(lists, 0, lists.length/2);
            ListNode[] myArray2 = Arrays.copyOfRange(lists, lists.length/2, lists.length);
            //System.out.println(myArray1[0].val); 
            //System.out.println(myArray2[0].val);
            return merge2(mergeKLists(myArray1), mergeKLists(myArray2)); 
        }
        
    }

    private ListNode merge2(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;  
        while(list1 != null || list2 != null){
            if(list1 == null){
                curr.next = list2; 
                break; 
            }
            if(list2 == null){
                curr.next = list1; 
                break; 
            }
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next; 
                curr = curr.next;  
            }
            else{
                curr.next = list2; 
                list2 = list2.next; 
                curr = curr.next; 
            }
        }

        return dummyHead.next; 
    }
}
