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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }

        ListNode pointer1 = null;
        ListNode pointer2 = null;
        ListNode pointer3 = null;
        ListNode pointer4 = null;

        ListNode curr = head;
        int index = 1;

        while(index < left){
            pointer1 = curr;
            curr = curr.next;
            index++;
        }

        pointer2 = curr;

        ListNode prev = null;
        while(curr != null && index <= right){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            index++;
        }

        pointer3 = prev;

        pointer4 = curr;

        pointer2.next = pointer4;
        if(pointer1 == null){
            return pointer3;
        }
        
        pointer1.next = pointer3;

        return head;
    }
}