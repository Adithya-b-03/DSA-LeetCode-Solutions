/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean f = true;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> l = new LinkedList<>();
            for(int i = 0 ; i < n ; i++){
                TreeNode t = q.poll();
                // int ind = (f==true) ? i : n-i-1;
                if(t.left != null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
                l.add(t.val);
            }
            if(f==false){
                Collections.reverse(l);
            }
            f = !f;
            ans.add(l);
        }
        return ans;
    }
}