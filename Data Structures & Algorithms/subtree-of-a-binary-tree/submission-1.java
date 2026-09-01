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
        String rootString = dfs(root);
        String subRootString = dfs(subRoot);

        return rootString.contains(subRootString);
    }



    private String dfs(TreeNode root){
        if (root == null){
            return "null";
        }

        return "," + root.val + ","+ dfs(root.left) + "," + dfs(root.right);
    }
}
