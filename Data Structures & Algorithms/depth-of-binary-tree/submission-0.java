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
    public int maxDepth(TreeNode root) {
        
        if (root == null){
            return 0;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;

        int cLeft = maxDepth(left);
        int cRight = maxDepth(right);

        return 1 + Math.max(cLeft, cRight);
    }
}
