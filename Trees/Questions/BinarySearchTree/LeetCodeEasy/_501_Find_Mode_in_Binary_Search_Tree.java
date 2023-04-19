package Trees.Questions.BinarySearchTree.LeetCodeEasy;

import java.util.*;

//   https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

public class _501_Find_Mode_in_Binary_Search_Tree {
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
        Map<Integer, Integer> map;
        public int[] findMode(TreeNode root) {
            map = new HashMap<>();
            addingElements(root);
            int max = -1;
            List<Integer> list = new ArrayList<>();
            for(Integer key : map.keySet()){
                if(max < map.get(key)){
                    max = map.get(key);
                    list.clear();
                    list.add(key);
                }
                else if(max == map.get(key)){
                    list.add(key);
                }
            }
            int[] arr = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                arr[i] = list.get(i);
            }
            return arr;
        }
        public void addingElements(TreeNode node){
            if(node == null){
                return;
            }
            if(map.containsKey(node.val)){
                int value = map.get(node.val);
                map.put(node.val, value+1);
            }
            else{
                map.put(node.val, 1);
            }
            addingElements(node.left);
            addingElements(node.right);
        }
    }
}
