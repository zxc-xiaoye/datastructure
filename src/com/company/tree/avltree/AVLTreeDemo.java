package com.company.tree.avltree;

/**
 * @author xiaoye
 * @create 2020-08-22 21:36
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 8, 7};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        avlTree.infixOrder();

        int i = avlTree.getRoot().height();
        int j  = avlTree.getRoot().leftHeight();
        int k = avlTree.getRoot().rightHeight();
    }
}
