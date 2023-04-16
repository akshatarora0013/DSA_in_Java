package Trees.Code;

import java.util.*;

public class _01_Generic_Tree_Construction_ {

    //creating node class
    private class Node{
        int data;
        ArrayList<Node> childern;

        Node(int data){
            this.data = data;
            this.childern = new ArrayList<>();
        }
    }
    private Node root;
    public int size;


    //constructor of our class to build a generic tree
    _01_Generic_Tree_Construction_(){
        Scanner input = new Scanner(System.in);
        this.root = takeInput(input, null, 0);
    }

    // to take input of every node in the tree
    public Node takeInput(Scanner input, Node parent, int iTHchild){
        if(parent == null){
            System.out.println("Enter the data of root node");
        }
        else{
            System.out.println("Enter the data for "+ (int)(iTHchild+1) + "th child of " + parent.data);
        }
        int nodeData = input.nextInt();
        Node node = new Node(nodeData);
        System.out.println("Enter the number of children");
        int children = input.nextInt();
        for (int i = 0; i < children; i++) {
            Node child = this.takeInput(input, node, i);
            node.childern.add(child);
        }
        this.size++;
        return node;
    }


    // Helper function to pass root node in the display function
    public void displaY(){
        this.display(this.root);
    }

    // Function to display the tree
    private void display(Node node){
        String str = node.data + "=> ";
        for (int i = 0; i < node.childern.size(); i++){
            str = str + node.childern.get(i).data + " ";
        }
        str = str + "END";
        System.out.println(str);
        for (int i = 0; i < node.childern.size(); i++) {
            this.display(node.childern.get(i));
        }
    }

}
