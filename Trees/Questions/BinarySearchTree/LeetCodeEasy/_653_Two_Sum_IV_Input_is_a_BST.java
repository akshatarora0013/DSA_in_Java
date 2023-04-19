package Trees.Questions.BinarySearchTree.LeetCodeEasy;

import java.util.*;

//   https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

public class _653_Two_Sum_IV_Input_is_a_BST {
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
        public boolean findTarget(TreeNode root, int k) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            inOrder(root,list);
            int n = list.size();
            for(int i=0,j=n-1;i<j;){
                int sum = list.get(i)+list.get(j);
                if(sum == k){
                    return true;
                }
                else if(sum > k){
                    j--;
                }
                else{
                    i++;
                }
            }
            return false;
        }

        public void inOrder(TreeNode node, List<Integer> list){
            if(node == null){
                return;
            }
            inOrder(node.left,list);
            list.add(node.val);
            inOrder(node.right,list);
            return;
        }
    }
}
