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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sbRoot = new StringBuilder();
        StringBuilder sbSubRoot = new StringBuilder();

        dfs(root, sbRoot);
        dfs(subRoot,sbSubRoot);

        return sbRoot.toString().contains(sbSubRoot.toString());
    }



    private void dfs(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(",null");
            return;
        }

        sb.append(",").append(root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
    }
}
