package tree;

public class TreeMainApp {

    public static void main(String[] args) {

        MyTree root = new MyTree(13,
                new MyTree(5,
                        new MyTree(1), new MyTree(30)),
                new MyTree(8));

        root.print(root);
        root.balanceTree(root);
        System.out.println();
        root.print(root);
    }
}
