package LinkedList.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/copy-list-with-random-pointer/description/

public class _138_Copy_List_with_Random_Pointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        private Map<Node, Node> map = new HashMap<>();
        public Node copyRandomList(Node head) {
            if(head == null){
                return null;
            }
            if(map.containsKey(head)){
                return map.get(head);
            }

            Node newNode = new Node(head.val);
            map.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);

            return newNode;
        }
    }
}
