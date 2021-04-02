package com.dandanpili.datastructure.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shaoruilin
 * @create 2021-04-02-13:25
 */
//二叉树的前中后序遍历
public class TreeTraversal {
    public static void main(String[] args) {
        String str = "ABC..D..EF..G..";
        TreeNode root = buildBinaryTree(str);

        System.out.print("前序遍历的递归法：");
        preOrderRecursion(root);

        System.out.print("\n前序遍历的迭代法：");
        List<TreeNode> preOrder = preOrderIteration(root);
        print(preOrder);

        System.out.print("\n中序遍历的递归法：");
        inOrderRecursion(root);

        System.out.print("\n中序遍历的迭代法：");
        List<TreeNode> inOrder = inOrderIteration(root);
        print(inOrder);

        System.out.print("\n后序遍历的递归法：");
        postOrderRecursion(root);

        System.out.print("\n后序遍历的迭代法：");
        List<TreeNode> postOrder = postOrderIteration(root);
        print(postOrder);


    }

    public static void print(List<TreeNode> order) {
        for (TreeNode node : order) {
            System.out.print(node.val + " ");
        }
    }


    /**
     * =================================================================
     * 前序遍历
     */
    //递归法
    public static void preOrderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);
    }

    //迭代法
    public static List<TreeNode> preOrderIteration(TreeNode node) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (node == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = node;
        stack.offerLast(cur);
        while (!stack.isEmpty()) {
            cur = stack.pollLast();
            res.addLast(cur);
            //先压入右节点，再压入左节点，然后栈先弹出的是左节点
            if (cur.right != null) {
                stack.offerLast(cur.right);
            }
            if (cur.left != null) {
                stack.offerLast(cur.left);
            }
        }
        return res;
    }

    /**
     * ==============================================================
     * 中序遍历
     */
    //递归法
    public static void inOrderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrderRecursion(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            inOrderRecursion(node.right);
        }
    }

    public static List<TreeNode> inOrderIteration(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            res.add(cur);
            cur = cur.right;
        }
        return res;
    }

    /**
     * ===========================================
     * 后序遍历
     */
    //递归法
    public static void postOrderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderRecursion(node.left);
        postOrderRecursion(node.right);
        System.out.print(node.val + " ");
    }
    //迭代法
    public static List<TreeNode> postOrderIteration(TreeNode node) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (node == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = node;
        stack.offerLast(cur);
        while (!stack.isEmpty()) {
            cur = stack.pollLast();
            res.addFirst(cur);
            if (cur.left != null) {
                stack.offerLast(cur.left);
            }
            if (cur.right != null) {
                stack.offerLast(cur.right);
            }
        }
        return res;
    }



    /**
     * 根据字符串构建一颗二叉树
     */
    public static int idx = -1;
    public static TreeNode buildBinaryTree(String str) {
        idx++;
        if (idx >= str.length() || str.charAt(idx) == '.') {
            return null;
        }
        TreeNode node = new TreeNode(str.charAt(idx));
        node.left = buildBinaryTree(str);
        node.right = buildBinaryTree(str);
        return node;
    }



}

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}

    public TreeNode(char val) {
        this.val = val;
    }
}
