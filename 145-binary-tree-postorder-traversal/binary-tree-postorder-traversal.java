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
        postOrder(root,op);
        return op;
    }
}