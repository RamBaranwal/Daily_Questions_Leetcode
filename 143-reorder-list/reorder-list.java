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
    private ListNode getMid(ListNode n){
        ListNode fast = n;
        ListNode slow = n;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }
    private ListNode reverse(ListNode n){
        ListNode curr = n;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        // find the mid of the list
        ListNode mid = getMid(head);
        ListNode fh = head;
        ListNode rev = reverse(mid);
        ListNode sh = rev;

        while(fh != null && sh != null){
            ListNode tempFH = fh.next;
            ListNode tempSH = sh.next;
            fh.next = sh;
            fh = tempFH;
            sh.next = fh;
            sh = tempSH;
        }
        if(sh != null){
            fh.next = sh;
        }
    }
}