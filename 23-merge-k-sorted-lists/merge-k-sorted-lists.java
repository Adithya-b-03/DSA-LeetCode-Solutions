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
public class Pair{
    int val;
    ListNode node;
    Pair(int val,ListNode node){
        this.val = val;
        this.node = node;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p->p.val));
        for(ListNode head : lists){
            if(head != null){
                pq.add(new Pair(head.val,head));
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            t.next = p.node;
            t = t.next;
            if(p.node.next != null){
                pq.add(new Pair(p.node.next.val,p.node.next));
            }
        }
        return dummy.next;
    }
}