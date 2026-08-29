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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode();
        ListNode tail = res;
        ListNode odd = head;
        while(odd != null){
            tail.val = odd.val;
            if(odd.next == null || odd.next.next == null){
                break;
            }
            tail.next = new ListNode();
            tail = tail.next;
            odd = odd.next.next;
        }

        ListNode even = head.next;
        while(even != null){
            tail.next = new ListNode();
            tail = tail.next;
            tail.val = even.val;

            if(even.next == null || even.next.next == null){
                break;
            } 
            even = even.next.next;
        }
        return res;
    }
}