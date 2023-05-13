package Trees.Questions.BinaryTree.LeetCodeMedium;
import java.util.*;

//   https://leetcode.com/problems/maximum-binary-tree/description/

public class _654_Maximum_Binary_Tree {
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            int max = 0;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] > nums[max]){
                    max = i;
                }
            }
            TreeNode root = new TreeNode(nums[max]);
            root.left = construct(0, max-1, nums);
            root.right = construct(max+1, nums.length-1, nums);
            return root;
        }
        private TreeNode construct(int start, int end, int[] nums){
            if(!(start <= end)){
                return null;
            }
            int max = start;
            for(int i = start + 1; i <= end; i++){
                if(nums[i] > nums[max]){
                    max = i;
                }
            }
            TreeNode node = new TreeNode(nums[max]);
            node.left = construct(start, max-1, nums);
            node.right = construct(max+1, end, nums);
            return node;
        }
    }
}
