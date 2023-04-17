package Trees.Questions.BinaryTree.LeetCodeEasy;

//  https://leetcode.com/problems/invert-binary-tree/description/

public class _226_Invert_Binary_Tree_ {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode ans = root;
        TreeNode temp = root.left;
        ans.left = root.right;
        ans.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return ans;
    }
}
