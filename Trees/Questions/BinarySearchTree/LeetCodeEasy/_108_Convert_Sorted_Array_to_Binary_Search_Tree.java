package Trees.Questions.BinarySearchTree.LeetCodeEasy;

//   https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            TreeNode root = help(0, nums.length-1, nums);

            return root;
        }
        TreeNode help(int start, int end, int[] nums){
            if(start > end){
                return null;
            }
            int mid = start + (end-start)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = help(start, mid-1, nums);
            node.right = help(mid+1, end, nums);
            return node;
        }
    }
}
