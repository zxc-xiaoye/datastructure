package com.company.tree.threadedbinarytree;


/**
 * @author xiaoye
 * @create 2020-08-15 18:18
 */
public class ThreadedBinaryTreeDemo {
}


class ThreadedBinaryTree{
    private Node root;

    // last Node
    private Node pre = null;

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

    /**
     * Thread Nodes
     * @param node Need threaded node
     */
    public void threadedNodes(Node node) {
        if(node == null) {
            return;
        }
        // 1. Thread left node
        threadedNodes(node.getLeft());

        // 2. Thread this node
        if(node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre != null && pre.getRight() == null) {
            // 让前驱结点的右指针指向当前结点
            pre.setRight(node);
            pre.setRightType(1);
        }
        // pre
        pre = node;

        // 3. Thread right node
        threadedNodes(node.getRight());
    }
}


class Node {
    private int id;

    private Node left;

    private Node right;

    // 0 指向子树 1 指向前驱或后继节点
    private int leftType;

    private int rightType;



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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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
