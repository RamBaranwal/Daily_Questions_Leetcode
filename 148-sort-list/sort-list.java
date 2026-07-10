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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }

        while(list1 != null){
            tail.next = list1;
            tail = list1;
            list1 = list1.next;
        }

        while(list2 != null){
            tail.next = list2;
            tail = list2;
            list2 = list2.next;
        }

        return dummyNode.next;
    }

    private ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
}