class Solution {
    private int pre = 0;
    private int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++; // Đã duyệt xong root hiện tại trong inorder
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, stop);

        return root;
    }
}