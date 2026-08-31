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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pre = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int index = 1;

        ArrayList<Integer> list = new ArrayList<>();
        while(curr.next != null){
            if(((pre.val > curr.val) && (curr.val < next.val)) || ((pre.val < curr.val) && (curr.val > next.val))){
                list.add(index);
            }
            pre = curr;
            curr = next;
            next = next.next;
            index++;
        }

        // Collections.sort(list);
        // System.out.println(list);
        int[] arr = {-1, -1};
        if(list.size() > 1){
            arr[1] = list.get(list.size() - 1) - list.get(0);
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < list.size(); i++){
                min = Math.min(min, list.get(i) - list.get(i - 1));
            }
            arr[0] = min;
        }

        return arr;
    }
}