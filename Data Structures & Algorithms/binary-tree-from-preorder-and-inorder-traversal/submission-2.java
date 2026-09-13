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
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return build(
            preorder,
            0, inorder.length-1
        );

    }

    private TreeNode build(
        int[] preorder,
        int inorderStart, int inorderEnd
    ){

        if (inorderStart > inorderEnd){
            return null;
        }

        int num = preorder[preorderIndex++];
        int inorderIndex = inorderIndexMap.get(num);
        int leftSize = inorderIndex - inorderStart;

        TreeNode left = build(
            preorder,
            inorderStart, inorderIndex-1
        );
        
        TreeNode right = build(
            preorder,
            inorderIndex+1, inorderEnd
        );

        TreeNode root = new TreeNode(
            num,
            left,
            right
        );

        return root;
    }
}
