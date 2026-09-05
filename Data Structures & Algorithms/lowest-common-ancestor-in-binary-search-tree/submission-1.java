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

// We have no work to do on the back up call stack, so we can eliminate recursion by using while loop

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null){
            if (p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }
}
