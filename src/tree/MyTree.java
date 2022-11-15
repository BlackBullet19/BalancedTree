package tree;

import java.util.*;

public class MyTree implements MyTreeInterface {

    public int value;
    public MyTree left;
    public MyTree right;
    List<Integer> listOfValues;

    public MyTree(int value, MyTree left, MyTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public MyTree(int value) {
        this.value = value;
    }

    @Override
    public void balanceTree(MyTree root) {
        copyAllDataToArrayListAndSort(root);
        int indexOfRoot = listOfValues.indexOf(root.value);
        Integer[] valuesArray = listOfValues.toArray(new Integer[0]);
        Integer[] valuesArrayLeft = Arrays.copyOfRange(valuesArray, 0, indexOfRoot);
        Integer[] valuesArrayRight = Arrays.copyOfRange(valuesArray, indexOfRoot + 1, valuesArray.length);
        add(root, valuesArrayLeft);
        add(root, valuesArrayRight);
    }

    @Override
    public void copyAllDataToArrayListAndSort(MyTree root) {
        listOfValues = new ArrayList<>();
        Queue<MyTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            MyTree node = queue.remove();

            listOfValues.add(node.value);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        Collections.sort(listOfValues);
    }

    @Override
    public void add(MyTree root, Integer[] restArray) {
        int mid = restArray.length / 2;

        if (restArray.length >= 3) {
            if (root.value > restArray[mid]) {
                root.left = new MyTree(restArray[mid]);
            } else {
                root.right = new MyTree(restArray[mid]);
            }

            Integer[] intsLeft = Arrays.copyOfRange(restArray, 0, mid);
            if (root.value > intsLeft[intsLeft.length - 1]) {
                add(root.left, intsLeft);
            } else {
                add(root.right, intsLeft);
            }

            Integer[] intsRight = Arrays.copyOfRange(restArray, mid + 1, restArray.length);
            if (root.value < intsRight[intsRight.length - 1]) {
                add(root.right, intsRight);
            } else {
                add(root.left, intsRight);
            }
        }

        if (restArray.length == 2) {
            if (root.value > restArray[1]) {
                root.left = new MyTree(restArray[0]);
                root.left.right = new MyTree(restArray[1]);
            }

            if (root.value < restArray[1]) {
                root.right = new MyTree(restArray[1]);
                root.right.left = new MyTree(restArray[0]);
            }
        }

        if (restArray.length == 1) {
            if (root.value > restArray[0]) {
                root.left = new MyTree(restArray[0]);
            } else {
                root.right = new MyTree(restArray[0]);
            }
        }
    }

    @Override
    public void print(MyTree root) {

        Queue<MyTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            MyTree node = queue.remove();
            System.out.println(node.value);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
