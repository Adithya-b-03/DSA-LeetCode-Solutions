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
    public ListNode findKthNode(ListNode t,int k){
        while(t!=null && k!=0){
            t = t.next;
            k--;
        }
        return t;
    }
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t = head;
        ListNode past = null;
        while(t!=null){
            ListNode kthNode = findKthNode(t,k-1);
            if(kthNode == null){
                if(past != null){
                    past.next = t;
                }
                 break;
            }
            ListNode future = kthNode.next;
            kthNode.next = null;
            reverseList(t);
            if(t == head){
                head = kthNode;
            }
            else{
                past.next = kthNode;
            }
            past = t;
            t = future;
            }
            return head;
        }

    }
