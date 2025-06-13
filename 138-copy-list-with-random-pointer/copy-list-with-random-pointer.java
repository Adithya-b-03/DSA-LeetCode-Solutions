/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node t = head;
        while(t!=null){
            Node copy = new Node(t.val);
            copy.next = t.next;
            t.next = copy;
            t = t.next.next;
        }
        t = head;
        while(t!=null){
            Node copy = t.next;
            if(t.random!=null){
            copy.random = t.random.next;
            }
            else{
                copy.random = null;
            }
            t = t.next.next;
        }
        Node dummy = new Node(-1);
        Node res = dummy;
        t = head;
        while(t!=null){
            res.next = t.next;
            t.next = t.next.next;
            res = res.next;
            t = t.next;
        }
        return dummy.next;
    }
}