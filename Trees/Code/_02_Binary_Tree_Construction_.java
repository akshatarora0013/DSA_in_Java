package Trees.Code;

import java.util.*;

public class _02_Binary_Tree_Construction_ {

    //creating node class
    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    private Node root = null;
    public int size = 0;


    //constructor of our class to build a binary tree
    _02_Binary_Tree_Construction_(){
        Scanner input = new Scanner(System.in);
        this.root = takeInput(input, null);
    }

    // to take input of every node in the tree
    public Node takeInput(Scanner input, Node parent){
        // Input is taken in pre order and for null the input must be -1
        int nodedata = input.nextInt();
        if(nodedata == -1){
            return null;
        }
        Node node = new Node(nodedata);
        node.left = takeInput(input, node);
        node.right = takeInput(input, node);
        this.size++;
        return node;
    }


    // Helper function to pass root node in the display function
    public void display(){
        this.display(this.root);
    }

    // Function to display the tree
    private void display(Node node){
        String str = "";
        if(node.left != null){
            str = str + node.left.data + "=> ";
        }
        else{
            str = str + "END => ";
        }

        str = str + node.data;

        if(node.right != null){
            str = str + "<= " + node.right.data;
        }
        else{
            str = str + " <= END";
        }
        System.out.println(str);

        if(node.left != null){
            this.display(node.left);
        }
        if(node.right != null){
            this.display(node.right);
        }
    }


    // Helper function to pass the root node in the height function
    public int height(){
        return height(this.root);
    }

    // function to return the height of the tree
    private int height(Node node){
        if(node == null){
            return -1;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left,right) + 1;
    }


    // Helper function to pass root node in the preOrderDisplay function
    public void preOrderDisplay(){
        preOrderDisplay(this.root);
    }

    // funciton to print the tree in pre order format;
    private void preOrderDisplay(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrderDisplay(node.left);
        preOrderDisplay(node.right);
    }


    // Helper function to pass root node in the inOrderDisplay function
    public void inOrderDisplay(){
        inOrderDisplay(this.root);
    }

    // function to print the tree in In order format;
    private void inOrderDisplay(Node node){
        if(node == null){
            return;
        }
        inOrderDisplay(node.left);
        System.out.print(node.data + " ");
        inOrderDisplay(node.right);
    }


    // Helper function to pass root node in the postOrderDisplay function
    public void postOrderDisplay(){
        inOrderDisplay(this.root);
    }

    // function to print the tree in post Order format;
    private void postOrderDisplay(Node node){
        if(node == null){
            return;
        }
        postOrderDisplay(node.left);
        postOrderDisplay(node.right);
        System.out.print(node.data + " ");
    }


    // Function to print the tree in Level Order format
    public void levelOrderDisplay(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            Node rm = queue.removeFirst();
            System.out.print(rm.data + " ");

            if(rm.left != null){
                queue.addLast(rm.left);
            }
            if(rm.right != null){
                queue.addLast(rm.right);
            }
        }
    }
}
