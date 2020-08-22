package com.company.tree.avltree;


/**
 * @author xiaoye
 * @create 2020-08-22 21:21
 */
public class Node {
    private int value;

    private Node left;

    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int leftHeight() {
        if (this.left == null) {
            return 0;
        }
        return this.left.height();
    }

    public int rightHeight() {
        if (this.right == null) {
            return 0;
        }
        return this.right.height();
    }

    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    /**
     * 左旋
     */
    private void leftRotate() {
        // 以当前结点的值创建新的结点
        Node newNode = new Node(value);
        // 把新的结点的左子树设置成当前结点的左子树
        newNode.left = this.left;
        // 把新的结点的右子树设置成当前结点的右子树的左子树
        newNode.right = this.right.left;
        // 把当前结点的值替换成右子结点的值
        this.value = right.value;
        // 把当前结点的右子树设置成当前结点的右子树的右子树
        this.right = this.right.right;
        // 把当前结点的左子树设置成新的结点
        this.left = newNode;
    }

    /**
     * 右旋
     */
    private void rightRotate() {
        // 以当前结点的值创建新的结点
        Node newNode = new Node(this.value);
        // 把新结点的右子树设置为当前结点的右子树
        newNode.right = this.right;
        // 把新结点的左子树设置为当前结点的左子树的右子树
        newNode.left = this.left.right;
        // 把当前结点的值设置为左子结点的值
        this.value = left.value;
        // 把当前结点的左子树设置为左子树的左子树
        this.left = this.left.left;
        // 把当前结点的右子树设置为新的结点
        this.right = newNode;
    }

    public void add(Node node) {
        if(node == null) {
            return;
        }
        if(node.value < this.value) {
            if(this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        // 添加完后，判断左右子树结点的高度
        /*
        当符合左旋时， 如果当前结点的右结点的左子树高度大于当前结点右结点的右子树高度
        先对当前结点的右结点进行右旋转
         */
        if ((this.rightHeight() - this.leftHeight()) > 1) {
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightRotate();
            }
            leftRotate();
            return;
        }

        /*
        当符合右旋时， 如果当前结点的左结点的右子树高度大于当前结点左结点的左子树高度
        先对当前结点的左结点进行左旋转
         */
        if ((this.leftHeight() - this.rightHeight()) > 1) {
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                this.left.leftRotate();
            }
            rightRotate();
        }
    }

    /**
     * 查找要删除的结点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if(value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            return this;
        } else {
            if(value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if(value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
