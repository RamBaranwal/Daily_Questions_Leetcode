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
        ListNode slow = n;
        ListNode fast = n;
        ListNode prev = null;
        if(n.next == null || n == null){
            return n;
        }
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    private ListNode reverse(ListNode n){
        ListNode curr = n;
        ListNode prev = null;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid;
        ListNode revList = reverse(right);
        while(left != null && revList != null){
            if(left.val != revList.val){
                return false;
            }
            left = left.next;
            revList = revList.next;
        }
        // if(left != null){
        //     return false;
        // }
        return true;
    }
}