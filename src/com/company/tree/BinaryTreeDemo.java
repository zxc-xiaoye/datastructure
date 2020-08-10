package com.company.tree;

/**
 * @author xiaoye
 * @create 2020-08-10 20:45
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);

        binaryTree.setRoot(root);

        System.out.println("preOrder >>");
        binaryTree.preOrder();

        System.out.println("infixOrder >>");
        binaryTree.infixOrder();

        System.out.println("postOrder >>");
        binaryTree.postOrder();


        Node result = binaryTree.preOrderSearch(5);
        System.out.println(result);


    }
}

class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if(this.root == null) {
            System.out.println("Tree is null");
            return;
        }
        this.root.preOrder();
    }

    public void infixOrder() {
        if(this.root == null) {
            System.out.println("Tree is null");
            return;
        }
        this.root.infixOrder();
    }

    public void postOrder() {
        if(this.root == null) {
            System.out.println("Tree is null");
            return;
        }
        this.root.postOrder();
    }


    public Node preOrderSearch(int id) {
        if(root != null) {
            return root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    public Node infixOrderSearch(int id) {
        if(root != null) {
            return root.infixOrderSearch(id);
        } else {
            return null;
        }
    }

    public Node postOrderSearch(int id) {
        if(root != null) {
            return root.postOrderSearch(id);
        } else {
            return null;
        }
    }
}


class Node {
    private int id;

    private Node left;

    private Node right;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        // 左节点前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 右节点前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public Node preOrderSearch(int id) {
        if(this.id == id) {
            return this;
        }
        Node result = null;
        // forward left
        if(this.left != null) {
            result = this.left.preOrderSearch(id);
        }
        if(result != null) {
            return result;
        }
        // forward right
        if(this.right != null) {
            result = this.right.preOrderSearch(id);
        }
        return result;
    }

    public Node infixOrderSearch(int id) {
        Node result = null;
        if(this.left != null) {
            result = this.left.infixOrderSearch(id);
        }
        if(result != null) {
            return result;
        }
        if (this.id == id) {
            return this;
        }
        if(this.right != null) {
            result = this.right.infixOrderSearch(id);
        }

        return result;
    }

    public Node postOrderSearch(int id) {
        Node result = null;
        if(this.left != null) {
            result = this.left.postOrderSearch(id);
        }
        if(result != null) {
            return result;
        }
        if(this.right != null) {
            result = this.right.postOrderSearch(id);
        }
        if(result != null) {
            return result;
        }
        if(this.id == id) {
            return this;
        }
        return null;
    }
}