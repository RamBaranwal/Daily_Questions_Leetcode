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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode last = head;
        int length = 1;
        while(last.next != null){
            last = last.next;
            length++;
        }
        k = k % length;
        if(k == 0){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        for(int i = 0; i < length - k; i++){
            prev = curr;
            curr = curr.next;
        }
        last.next = head;
        prev.next = null;
        return curr;
    }
}