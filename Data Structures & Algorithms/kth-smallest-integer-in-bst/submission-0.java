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
    int count;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        ans = 0;
        inorder(root);
        return ans;

    }
    public void inorder(TreeNode root){
        if(root.left != null) inorder(root.left);
        count--;
        if(count == 0){
            ans = root.val;
            return;
        }
        if(root.right != null) inorder(root.right);
    }
}
