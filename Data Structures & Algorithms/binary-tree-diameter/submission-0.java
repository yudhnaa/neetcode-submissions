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
    private int maxHeight = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calHeight(root);
        return maxHeight;
    }

    public int calHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftHeight = calHeight(root.left);
        int rightHeight = calHeight(root.right);

        maxHeight = Math.max(maxHeight, rightHeight+leftHeight);

        return 1 + Math.max(rightHeight, leftHeight);
    }
}
