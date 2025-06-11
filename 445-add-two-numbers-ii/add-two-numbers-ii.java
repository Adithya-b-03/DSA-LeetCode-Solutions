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
        ListNode past =null;
        ListNode present = head;
        while(present != null){
            ListNode future = present.next;
            present.next = past;
            past = present;
            present = future;
        }
        return past;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2; 
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(t1 != null){
            s1.push(t1.val);
            t1 =t1.next;
        }
        while(t2 != null){
            s2.push(t2.val);
            t2 = t2.next;
        }
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum = carry;
            if(!s1.isEmpty()){
                sum += s1.peek();
                s1.pop();
            }
            if(!s2.isEmpty()){
                sum += s2.peek();
                s2.pop();
            }
            ListNode n = new ListNode(sum%10);
            t.next = n;
            t = t.next;
            carry = sum/10;
        }
        if(carry != 0){
            ListNode n = new ListNode(carry);
            t.next = n;
            t = t.next;
        }
        ListNode h = reverseList(dummy.next);
        return h;
    }
}