package Trees.Questions.BinarySearchTree.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

public class _230_Kth_Smallest_Element_in_a_BST {
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
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list.get(k-1);
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
