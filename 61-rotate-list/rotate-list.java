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
    public ListNode findNthNode(ListNode t,int n)
    {
        while(t!=null && n!=0){
            t=t.next;
            n--;
        }
        return t;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        if(k%len == 0){
            return head;
        }
        k = k%len;
        tail.next = head;
        ListNode newTail = findNthNode(head,len-k-1);
        head = newTail.next;
        newTail.next = null;
        return head;
    }    
}