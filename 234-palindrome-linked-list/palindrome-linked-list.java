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
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode present = head;
        ListNode past = null;
        while(present != null){
            ListNode future = present.next;
            present.next = past;
            past = present;
            present = future;
        }
        return past;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = reverseList(slow.next);
        while(second != null){
            if(first.val != second.val){
                slow.next = reverseList(slow.next);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        slow.next = reverseList(slow.next);
        return true;
    }
}