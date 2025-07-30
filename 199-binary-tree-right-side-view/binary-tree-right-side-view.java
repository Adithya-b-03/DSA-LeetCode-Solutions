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
    public void help(TreeNode root, int l,List<Integer> ans){
        if(root==null){
            return;
        }
        if(l == ans.size()){
            ans.add(root.val);
        }
        help(root.right,l+1,ans);
        help(root.left,l+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null){
            return ans;
        }
        help(root,0,ans);
        return ans;
    }
}