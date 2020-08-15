package com.company.tree;

/**
 * @author xiaoye
 * @create 2020-08-15 18:19
 */
public class Node {
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

    public void delNode(int id) {
        if(this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if(this.right != null && this.right.id == id) {
            this.right = null;
        }
        if(this.left != null) {
            this.left.delNode(id);
        }

        if (this.right != null) {
            this.right.delNode(id);
        }

    }
}
