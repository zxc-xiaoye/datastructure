package com.company.tree.binarysorttree;

/**
 * @author xiaoye
 * @create 2020-08-19 21:03
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 7, 2, 1, 9, 5};

        BinarySortTree binarySortTree = new BinarySortTree();

        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.infixOrder();
        binarySortTree.delNode(6);
        System.out.println("After delNode");
        binarySortTree.infixOrder();
    }

}

