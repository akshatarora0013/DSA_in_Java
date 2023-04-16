package Trees.Code;

public class _03_Binary_Search_Tree_main_ {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        _03_Binary_Search_Tree_Construction_ tree1 = new _03_Binary_Search_Tree_Construction_(arr);
        tree1.display();
        System.out.println();
        tree1.insert(10);
        tree1.display();
        System.out.println();


        _03_Binary_Search_Tree_Construction_ tree2 = new _03_Binary_Search_Tree_Construction_();
        tree2.insert(30);
        tree2.insert(10);
        tree2.insert(20);
        tree2.insert(40);
        tree2.insert(50);
        tree2.insert(35);

        tree2.display();
        System.out.println();

//        System.out.println(tree2.find(35));
//        System.out.println(tree2.find(45));
//
//        System.out.println("Max element in Tree1 is: " + tree1.max());
//        System.out.println("Max element in Tree2 is: " + tree2.max());


        tree2.remove(40);
        tree2.display();

    }
}
