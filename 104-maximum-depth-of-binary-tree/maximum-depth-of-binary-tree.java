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
    public static int height(TreeNode root){
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return 1 + Math.max(l,r);
    }
    public int maxDepth(TreeNode root) {
        return height(root);
    }
}