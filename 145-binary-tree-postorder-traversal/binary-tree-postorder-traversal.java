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
    public static void postOrder(TreeNode root,List<Integer> op){
        if(root == null){
            return;
        }
        postOrder(root.left,op);
        postOrder(root.right,op);
         op.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        // postOrder(root,op);
        if(root==null){
            return op;
        }
        Stack<TreeNode>s1 = new Stack<>();
        Stack<TreeNode>s2 = new Stack<>();
        TreeNode n = root;
        s1.push(n);
        while(!s1.isEmpty()){
            TreeNode t = s1.pop();
            s2.push(t);
            if(t.left != null){
                s1.push(t.left);
            }
            if(t.right != null){
                s1.push(t.right);
            }
        }
        while(!s2.isEmpty()){
            op.add(s2.pop().val);
        }
        return op;
    }
}