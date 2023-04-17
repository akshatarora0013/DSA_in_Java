package Trees.Questions.BinaryTree.LeetCodeMedium;

//  https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/

public class _2415_Reverse_Odd_Levels_of_Binary_Tree {
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
        public TreeNode reverseOddLevels(TreeNode root) {
            reverse(root.right, root.left, 1);
            return root;
        }
        private void reverse(TreeNode node1, TreeNode node2, int level){
            if(node1 == null || node2 == null){
                return;
            }
            if(level%2 == 1){
                int temp = node1.val;
                node1.val = node2.val;
                node2.val = temp;
            }
            level++;
            reverse(node1.left, node2.right, level);
            reverse(node1.right, node2.left, level);
        }
    }
}
