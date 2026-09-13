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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return build(
            preorder, 0, preorder.length-1,
            0, inorder.length-1
        );

    }

    private TreeNode build(
        int[] preorder, int preorderStart, int preorderEnd, 
        int inorderStart, int inorderEnd
    ){

        if (preorderStart > preorderEnd || inorderStart > inorderEnd){
            return null;
        }

        int num = preorder[preorderStart];
        int inorderIndex = inorderIndexMap.get(num);
        int leftSize = inorderIndex - inorderStart;

        TreeNode left = build(
            preorder, preorderStart + 1, preorderStart + leftSize,
            inorderStart, inorderIndex-1
        );
        
        TreeNode right = build(
            preorder, preorderStart + leftSize + 1, preorderEnd,
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
