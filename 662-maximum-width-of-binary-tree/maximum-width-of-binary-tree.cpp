/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    unsigned long long w = 0;
    int widthOfBinaryTree(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        queue<pair<TreeNode*,unsigned long long>> q;
        q.push({root,0});
        while(!q.empty()){
            int n = q.size();
            unsigned long long min = q.front().second;
            unsigned long long f,l;
            for(int i = 0 ; i < n ; i++){
                unsigned long long c = q.front().second - min;
                TreeNode* node = q.front().first;
                q.pop();
                if(i==0){
                    f=c;
                }
                if(i==n-1){
                    l=c;
                }
                if(node->left){
                    q.push({node->left,2*c+1});
                }
                if(node->right){
                    q.push({node->right,2*c+2});
                }
            }
            w = max(w,l-f+1);
        }
        return static_cast<int>(w);
    }
};