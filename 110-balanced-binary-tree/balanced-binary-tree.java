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
    public int balance(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = balance(root.left);
        int r = balance(root.right);
        if(l==-1 || r==-1){
            return -1;
        }
        if(Math.abs(r-l)>1){
            return -1;
        }
        return 1+Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        int a = balance(root);
        if(a==-1){
            return false;
        }
        else{
            return true;
        }
    }
}