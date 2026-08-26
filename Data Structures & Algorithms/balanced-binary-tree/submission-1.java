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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return calHeight(root) == -1 ? false : true;
    }

    private int calHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftHeight = calHeight(root.left);
        if (leftHeight == -1){
            return -1;
        }

        int rightHeight = calHeight(root.right);
        if (rightHeight == -1){
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        
        int nodeHeight = Math.max(leftHeight, rightHeight);

        return 1 + nodeHeight;

    }
}
