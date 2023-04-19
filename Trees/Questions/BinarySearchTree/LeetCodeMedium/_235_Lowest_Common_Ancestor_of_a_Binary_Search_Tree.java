package Trees.Questions.BinarySearchTree.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> listP = new ArrayList<>();
            listP = path(root, p, listP);
            List<TreeNode> listQ = new ArrayList<>();
            listQ = path(root, q, listQ);
            for(int i = 0; i < Math.min(listP.size(), listQ.size()); i++){
                if(listP.get(i).val != listQ.get(i).val){
                    return listP.get(i-1);
                }
            }
            if(listP.size() < listQ.size()){
                return listP.get(listP.size()-1);
            }
            return listQ.get(listQ.size()-1);
        }
        List<TreeNode> path(TreeNode node, TreeNode find, List<TreeNode> list){
            if(node.val == find.val){
                list.add(node);
                return list;
            }
            list.add(node);
            if(node.val < find.val){
                path(node.right, find, list);
            }
            else{
                path(node.left, find, list);
            }
            return list;
        }
    }
}
