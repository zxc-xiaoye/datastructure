package com.company.tree.avltree;


/**
 * @author xiaoye
 * @create 2020-08-22 21:31
 */
public class AVLTree {
    private Node root;


    public int leftHeight() {
        if (root == null) {
            return 0;
        }
        return root.leftHeight();
    }

    public int rightHeight() {
        if (root == null) {
            return 0;
        }
        return root.rightHeight();
    }


    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }
            Node parent = searchParent(value);
            if (targetNode.getLeft() == null && targetNode.getRight() == null) {
                // 删除结点为叶子结点
                // 判断是左子结点 右子结点
                if(parent.getLeft() != null && parent.getLeft().getValue() == value) {
                    parent.setLeft(null);
                } else if (parent.getRight() != null && parent.getRight().getValue() == value) {
                    parent.setRight(null);
                }
            } else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
                // 删除有两个子结点的结点
                // 找到右子树最小值删除 或者 找到左子树最大值删除
                int min = delRightTreeMin(targetNode.getRight());
                targetNode.setValue(min);
            } else {
                // 删除有一个子结点的结点
                if (targetNode.getLeft() != null ) {
                    // targetNode 有左子结点
                    if (parent != null) {
                        if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                            parent.setLeft(targetNode.getLeft());
                        } else {
                            parent.setRight(targetNode.getLeft());
                        }
                    } else {
                        root = targetNode.getLeft();
                    }
                } else {
                    // targetNode 有右子结点
                    if (parent != null) {
                        if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                            parent.setLeft(targetNode.getRight());
                        } else {
                            parent.setRight(targetNode.getRight());
                        }
                    } else {
                        root = targetNode.getRight();
                    }
                }
            }
        }

    }

    /**
     * 找到最小结点 删除并返回
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.getLeft() != null) {
            target = target.getLeft();
        }
        delNode(target.getValue());
        return target.getValue();
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    public Node searchParent(int value) {
        if(root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    public void add(Node node) {
        if (root == null) {
            this.root = node;
            return;
        }
        root.add(node);
    }

    public void infixOrder() {
        if (root == null) {
            return;
        }
        root.infixOrder();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
