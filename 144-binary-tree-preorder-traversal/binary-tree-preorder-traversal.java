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
    public static void preOrder(TreeNode root,List<Integer> op){
        if(root == null){
            return;
        }
        op.add(root.val);
        preOrder(root.left,op);
        preOrder(root.right,op);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        // preOrder(root,op);
        if(root == null){
            return op;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode n = s.pop();
            op.add(n.val);
            if(n.right != null){
                s.push(n.right);
            }
            if(n.left != null){
                s.push(n.left);
            }
        }
        return op;
    }
}