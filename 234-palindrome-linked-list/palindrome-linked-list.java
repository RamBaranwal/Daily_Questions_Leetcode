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
        if(n == null || n.next == null){
            return n;
        }
        ListNode slow = n;
        ListNode fast = n;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode rev(ListNode n){
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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode revSecPart = rev(mid);
        System.out.println(mid.toString());
        System.out.println(revSecPart.toString());
        while(head != null && revSecPart != null){
            if(head.val != revSecPart.val){
                return false;
            }
            head = head.next;
            revSecPart = revSecPart.next;
        }
        return true;
    }
}