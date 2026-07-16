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
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        if(curr == null || next == null){
            return new int[] {-1, -1};
        }
        int index = 2;
        ArrayList<Integer> store = new ArrayList<>();

        while(curr != null && next != null){
            if((prev.val < curr.val && curr.val > next.val) ||
            (prev.val > curr.val && curr.val < next.val)){
                store.add(index);
            }
            index++;
            prev = curr;
            curr = next;
            next = next.next;
        }
        if(store.isEmpty() || store.size() == 1){
            return new int[] {-1, -1};
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < store.size(); i++){
            min = Math.min(min, store.get(i) - store.get(i - 1));
        }
        int max = store.get(store.size() - 1) - store.get(0);

        return new int[] {min, max};
    }
}