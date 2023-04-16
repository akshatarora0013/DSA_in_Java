package Trees.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/binary-tree-right-side-view/

public class _199_Binary_Tree_right_side_view {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            List<List<Integer>> list = levelOrder(root);
            for(int i = 0; i < list.size(); i++){
                List<Integer> temp = list.get(i);
                ans.add(temp.get(temp.size()-1));
            }
            return ans;
        }
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
            if(root==null){
                return finalAns;
            }
            q.add(root);
            while(!q.isEmpty()){
                int levels = q.size();
                List<Integer> subLevels = new ArrayList<>();
                for(int i=0;i<levels;i++){
                    if(q.peek().left!=null){
                        q.add(q.peek().left);
                    }
                    if(q.peek().right!=null){
                        q.add(q.peek().right);
                    }
                    subLevels.add(q.remove().val);
                }
                finalAns.add(subLevels);
            }
            return finalAns;
        }
    }
}
