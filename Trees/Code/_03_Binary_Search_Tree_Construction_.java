package Trees.Code;

public class _03_Binary_Search_Tree_Construction_ {

    //creating node class
    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;


    //constructor of our class to build a binary tree
    _03_Binary_Search_Tree_Construction_(){
        root = null;
    }
    _03_Binary_Search_Tree_Construction_(int[] array){
        root = null;
        this.root = construct(array, 0, array.length-1);
    }

    // Function to construct the binary search tree
    private Node construct(int[] array, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start)/2;
        Node node = new Node(array[mid]);

        node.left = construct(array, start, mid-1);
        node.right = construct(array, mid+1, end);

        return node;
    }


    //Inserting value one by one using insert function;
    public void insert(int data){
        Node nn = new Node(data);
        if(root == null){
            root = nn;
            return;
        }
        Node current = root;
        Node parent = null;

        while(true){
            parent = current;
            if(data < current.data){
                current = current.left;
                if(current == null){
                    parent.left = nn;
                    return;
                }
            }
            else{
                current = current.right;
                if(current == null){
                    parent.right = nn;
                    return;
                }
            }
        }
    }


    //Helper Function to pass root node in the find function
    public boolean find(int element){
        return find(root , element);
    }

    //Function to find an element in the tree
    private boolean find(Node node, int element){
        if(node == null){
            return false;
        }
        if(element > node.data){
            return find(node.right , element);
        }
        else if(element < node.data){
            return find(node.left, element);
        }
        else{
            return true;
        }
    }

    // Helper function to pass root node in the max function
    public int max(){
        return max(root);
    }

    //Function to find the max in BST
    private int max(Node node){
        if(node.right == null){
            return node.data;
        }
        return max(node.right);
    }


    //Helper function to pass arguments to remove function
    public void remove(int element){
        remove(root, null, false, element);
    }

    //function to remove a node
    private void remove(Node node, Node parent, boolean ilc, int item){
        if(node == null){
            return;
        }

        if(node.data > item){
            remove(node.left, node, true, item);
        }
        else if(node.data < item){
            remove(node.right, node, false, item);
        }
        //reched the element which we want to remove
        else{
            if(node.left == null && node.right == null){
                if(ilc){
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
            else if(node.left == null && node.right != null){
                if(ilc){
                    parent.left = node.right;
                }
                else{
                    parent.right = node.right;
                }
            }
            else if(node.left != null && node.right == null){
                if(ilc){
                    parent.left = node.left;
                }
                else{
                    parent.right = node.left;
                }
            }
            else{
                int max = max(node.left);
                node.data = max;
                remove(node.left, node, true, max);
            }
        }
    }


    // Helper function to pass root node in the display function
    public void display(){
        this.display(root);
    }

    // function to display the Binary search tree
    private void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        if(node.left != null){
            str = str + node.left.data + " => ";
        }
        else{
            str = str + "END => ";
        }
        str = str + node.data;
        if(node.right != null){
            str = str + " <= " + node.right.data;
        }
        else {
            str = str + " <= END";
        }
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
}
