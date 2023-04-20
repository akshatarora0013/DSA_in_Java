package Trees.Questions.BinaryTree.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/maximum-width-of-binary-tree/description/

public class _662_Maximum_Width_of_Binary_Tree {
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
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
//            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//            queue.add(new Pair<>(root, 0));
            int maxWidth = 0;

//            while(!queue.isEmpty()){
//                int levelLength = queue.size();
//                int levelStart = queue.peek().getValue();
//                int index = queue.peek().getValue();
//
//                for(int i = 0; i < levelLength; i++){
//                    Pair<TreeNode, Integer> pair = queue.poll();
//                    TreeNode node = pair.getKey();
//                    index = pair.getValue();
//                    if (node.left != null) {
//                        queue.add(new Pair<>(node.left, 2*index+1));
//                    }
//
//                    if (node.right != null) {
//                        queue.add(new Pair<>(node.right, 2*index+2));
//                    }
//                }
//                maxWidth = Math.max(maxWidth, index-levelStart + 1);
//            }
            return maxWidth;
        }
    }
}
