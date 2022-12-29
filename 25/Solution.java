class Solution {
    // public class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head; 
        }
        ListNode dummyHead = new ListNode(); 
        dummyHead.next = head; 
        ListNode prevEnd = dummyHead; 
        ListNode[] mark = new ListNode[2]; 
        mark[0] = prevEnd; 
        mark[1] = head; 
        while(chunkSwap(mark, k)){
            ; 
        }
        return dummyHead.next; 
        
    }

    private boolean chunkSwap(ListNode[] mark, int k){
        ListNode[] chunkNodes = new ListNode[k]; 
        ListNode prevEnd = mark[0]; 
        ListNode head = mark[1]; 
        //assign helper nodes
        ListNode curr = head; 
        for(int i = 0; i < k; i++){
            chunkNodes[i] = curr; 
            //fail to assign this chunk
            if(curr == null){
                prevEnd.next = head; 
                return false; 
            }
            curr = curr.next; 
        }
        mark[1] = chunkNodes[k-1].next;
        //connect backwards
        for(int i = (k - 1); i > 0; i--){
            //System.out.println(i + " " + k); 
            chunkNodes[i].next = chunkNodes[i-1]; 
        }
        //connect prevEnd to the start of new chunkNodes
        prevEnd.next = chunkNodes[k-1]; 
        mark[0] = chunkNodes[0]; 
        return true; 
    }
}
