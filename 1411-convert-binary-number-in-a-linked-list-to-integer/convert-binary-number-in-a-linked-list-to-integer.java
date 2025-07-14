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
    public int getDecimalValue(ListNode head) {
        ListNode t = head;
        int n = 0;
        while(t!=null){
            n++;
            t=t.next;
        }
        n--;
        t=head;
        int ans = 0;
        while(t!=null){
            ans += t.val*(1<<n);
            n--;
            t=t.next;
        }
        return ans;
    }
}