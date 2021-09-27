package com.study.oneWeekChallenge.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * 对于任意一颗树而言，前序遍历的形式总是：
 * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
 * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是：
 * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
 *
 * 因此，先通过前序遍历的第一个节点确定根节点，再在中序遍历中根据根节点的位置，得到左右子树区间的大小，从而递归构建子树。
 */
public class Day1_1_LeetCode105 {

    private static Map<Integer, Integer> map = new HashMap<>();
    private static int[] pre;
    private static int preidx;

    public static TreeNode mybuildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        // 根节点总是前序遍历中的第一个节点
        TreeNode root = new TreeNode(pre[preidx++]);
        int rootIndex = map.get(root.val);
        root.left = mybuildTree(left, rootIndex - 1);
        root.right = mybuildTree(rootIndex + 1, right);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        pre = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return mybuildTree(0, preorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}


