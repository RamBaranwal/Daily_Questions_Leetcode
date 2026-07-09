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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode n = new ListNode(digit);
            if(head == null){
                head = n;
                tail = n;
            }
            else{
                tail.next = n;
                tail = n;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp2 != null){
            int sum = temp2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode n = new ListNode(digit);
            tail.next = n;
            tail = n;
            temp2 = temp2.next;
        }

        while(temp1 != null){
            int sum = temp1.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode n = new ListNode(digit);
            tail.next = n;
            tail = n;
            temp1 = temp1.next;
        }

        if(carry != 0){
            tail.next = new ListNode(carry);
        }

        return head;
    }
}