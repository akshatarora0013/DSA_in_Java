package Trees.Questions.BinaryTree.LeetCodeMedium;

//  https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

public class _1448_Count_Good_Nodes_in_Binary_Tree {
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
        public int goodNodes(TreeNode root) {
            if(root == null){
                return 1;
            }
            return countGoodNodes(root, Integer.MIN_VALUE);
        }
        int countGoodNodes(TreeNode node, int maxVal){
            if(node == null){
                return 0;
            }
            int count = 0;
            if(node.val >= maxVal){
                count++;
                return count + countGoodNodes(node.left, node.val) + countGoodNodes(node.right, node.val);
            }
            return count + countGoodNodes(node.left, maxVal) + countGoodNodes(node.right, maxVal);
        }
    }
}
