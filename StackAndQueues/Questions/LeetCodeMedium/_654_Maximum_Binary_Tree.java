package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/maximum-binary-tree/description/

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
            Stack<TreeNode> stack = new Stack<>();
            for(int num: nums){
                TreeNode node = new TreeNode(num);
                while(!stack.isEmpty() && stack.peek().val < num){
                    node.left = stack.pop();
                }
                if(!stack.isEmpty()){
                    stack.peek().right = node;
                }
                stack.push(node);
            }
            while(stack.size() != 1){
                stack.pop();
            }
            if(stack.isEmpty()){
                return null;
            }
            return stack.pop();
        }
    }
}
