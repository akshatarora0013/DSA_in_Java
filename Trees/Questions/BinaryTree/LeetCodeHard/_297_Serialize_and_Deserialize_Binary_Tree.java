package Trees.Questions.BinaryTree.LeetCodeHard;

import java.util.*;

//    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

public class _297_Serialize_and_Deserialize_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return "";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder result = new StringBuilder();

            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node == null){
                    result.append("null ");
                    continue;
                }
                result.append(node.val+" ");
                queue.add(node.left);
                queue.add(node.right);
            }
            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == ""){
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));

            queue.add(root);

            for(int i = 1; i < values.length; i++){
                TreeNode parent = queue.poll();

                if(!values[i].equals("null")){
                    TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = leftNode;
                    queue.add(leftNode);
                }
                i++;
                if(!values[i].equals("null")){
                    TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = rightNode;
                    queue.add(rightNode);
                }
            }
            return root;
        }
    }
}
