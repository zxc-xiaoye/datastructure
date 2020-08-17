package com.company.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 * 树的带权路径长度（WPL）最小
 * WPL 所有叶子结点的带权路径长度之和
 * @author xiaoye
 * @create 2020-08-17 21:28
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);
        huffmanTree.preOrder();
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();

        for (int i : arr) {
            nodes.add(new Node(i));
        }
        while (nodes.size() > 1){
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.getValue() + right.getValue());
            parent.setLeft(left);
            parent.setRight(right);

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }

        return nodes.get(0);

    }
}

class Node implements Comparable<Node> {
    private int value;

    private Node left;

    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.getLeft() != null) {
            this.getLeft().preOrder();
        }

        if(this.getRight() != null) {
            this.getRight().preOrder();
        }
    }
}
