package Trees.Code;

public class _02_Binary_Tree_Main {
    public static void main(String[] args) {
        //sample input = 50 25 38 -1 -1 48 18 -1 -1 -1 45 85 -1 -1 60 -1 -1

        _02_Binary_Tree_Construction_ tree = new _02_Binary_Tree_Construction_();
        System.out.println();

        tree.display();
        System.out.println();

        System.out.println("Size = " + tree.size);

        System.out.println("height = " + tree.height());
        System.out.println();

        System.out.print("Pre order display: ");
        tree.preOrderDisplay();
        System.out.println();

        System.out.print("In order display: ");
        tree.inOrderDisplay();
        System.out.println();

        System.out.print("Post Order display: ");
        tree.postOrderDisplay();
        System.out.println();

        System.out.print("Level Order display: ");
        tree.levelOrderDisplay();
        System.out.println();

    }
}
