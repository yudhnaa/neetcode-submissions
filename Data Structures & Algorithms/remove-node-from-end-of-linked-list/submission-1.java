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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastP = dummyNode;
        ListNode slowP = dummyNode;

        for (int i = 0; i < n; i++){
            fastP = fastP.next;
        }

        while (fastP.next != null){
            fastP = fastP.next;
            slowP = slowP.next;
        }

        slowP.next = slowP.next.next;
        
        return dummyNode.next;
        
    }
}
