package test;

import tree.MyTree;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeTest {

    MyTree root =
            new MyTree(20,
                    new MyTree(4,
                            new MyTree(6, null, new MyTree(7)), new MyTree(9)),
                    new MyTree(52,
                            new MyTree(31, new MyTree(38), null),
                            new MyTree(40, new MyTree(28), new MyTree(35))));


    @org.junit.jupiter.api.Test
    void balanceTreeCheckingValueOfSecondLevelLeftNode() {
        root.balanceTree(root);
        int result = root.right.left.value;
        assertEquals(31, result);
    }

    @org.junit.jupiter.api.Test
    void balanceTreeCheckingValueOfFirstLevelLeftNode() {
        root.balanceTree(root);
        int result = root.left.value;
        assertEquals(7, result);
    }

    @org.junit.jupiter.api.Test
    void balanceTreeCheckingValueOfSecondLevelRightNode() {
        root.balanceTree(root);
        int result = root.left.right.value;
        assertEquals(9, result);
    }

    @org.junit.jupiter.api.Test
    void balanceTreeCheckingValueOfThirdLevelRightNode() {
        root.balanceTree(root);
        int result = root.left.left.right.value;
        assertEquals(6, result);
    }
}