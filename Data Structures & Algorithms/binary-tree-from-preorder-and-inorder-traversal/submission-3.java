class Solution {
    private int[] inMap = new int[6001];
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap[inorder[i] + 3000] = i;
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int num = preorder[preorderIndex++];
        int inorderIndex = inMap[num + 3000];

        TreeNode left = build(preorder, inorderStart, inorderIndex - 1);
        TreeNode right = build(preorder, inorderIndex + 1, inorderEnd);

        return new TreeNode(num, left, right);
    }
}