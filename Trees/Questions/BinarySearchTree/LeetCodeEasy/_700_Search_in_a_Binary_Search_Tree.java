package Trees.Questions.BinarySearchTree.LeetCodeEasy;

//  https://leetcode.com/problems/search-in-a-binary-search-tree/description/

public class _700_Search_in_a_Binary_Search_Tree {
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

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null || root.val == val){
                return root;
            }
            if(root.val > val){
                return searchBST(root.left, val);
            }
            return searchBST(root.right, val);
        }
    }
}
