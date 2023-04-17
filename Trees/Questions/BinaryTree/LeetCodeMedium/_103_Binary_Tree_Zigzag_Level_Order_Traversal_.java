package Trees.Questions.BinaryTree.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal_ {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            if(root==null){
                return ans;
            }
            queue.add(root);
            while(!queue.isEmpty()){
                int levels = queue.size();
                List<Integer> subLevels = new ArrayList<>();
                for(int i=1;i<=levels;i++){
                    if(queue.peek().left!=null){
                        queue.add(queue.peek().left);
                    }
                    if(queue.peek().right!=null){
                        queue.add(queue.peek().right);
                    }
                    subLevels.add(queue.remove().val);
                }
                ans.add(subLevels);
            }
            for(int i = 0; i < ans.size(); i++){
                if(i % 2 != 0){
                    Collections.reverse(ans.get(i));
                }
            }
            return ans;
        }
    }
}
