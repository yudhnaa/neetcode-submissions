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
    public void reorderList(ListNode head) {

        // fastP moves twice as fast as slowP,
        // so when fastP reaches the end of the list,
        // slowP will be at the middle.
        ListNode slowP = head;
        ListNode fastP = head;

        while (fastP.next != null && fastP.next.next != null){
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        
        ListNode second = slowP.next;
        slowP.next = null;
        ListNode middleNode = reverseList(second);
        ListNode headNode = head;
        

        while (middleNode != null){
            ListNode temp1 = headNode.next;
            ListNode temp2 = middleNode.next;
            
            headNode.next = middleNode;
            middleNode.next = temp1;

            middleNode = temp2;
            headNode = temp1;
        }

        while (middleNode != null){
            System.out.println(middleNode.val);
            middleNode = middleNode.next;
        }
        
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }
}
