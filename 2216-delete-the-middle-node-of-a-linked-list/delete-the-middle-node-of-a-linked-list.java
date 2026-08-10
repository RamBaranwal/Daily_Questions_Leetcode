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
        ListNode fast = head;
        ListNode slow = head;
        if(slow.next == null){
            return head.next;
        }
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next != null){
            slow.next = slow.next.next;
        }
        else{
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        }
        return head;
    }
}