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

    private int level = 0;
    public int kthSmallest(TreeNode root, int k) {
        level = k;
        return dfs(root);
    }   

    private int dfs(TreeNode root) {
        if (root == null){
            return -1;
        }

        int left = dfs(root.left);
        if (left != -1){
            return left;
        }

        level = level - 1;
        if (level == 0){
            return root.val;
        }

        int right = dfs(root.right);
        if (right != -1){
            return right;
        }

        return -1;
    }

}
