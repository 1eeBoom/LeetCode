package medium;

import struct.TreeNode;

/**
 * Created By LeeBoom On 2019/3/27 15:33
 */

/**
 * 题目：
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 思路：
 * 前序遍历+递归。
 * 递归函数处理逻辑：
 * 1.将当前节点的右子树节点保存。
 * 2.将右子树指针指向左子树（现在左右子树指针都指向同一个）
 * 3.将右子树的最右子节点的右指针指向原来的左子树。
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode rightNode = null;
        //保存右子树节点
        if (root.right != null) {
            rightNode = root.right;
        }
        flatten(root.left);
        flatten(root.right);
        //右子树指针指向左子树
        root.right = root.left;
        //左子树置空
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        if (rightNode != null) {
            root.right = rightNode;
        }

    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t1.right = t5;
        t5.right = t6;
        flatten.flatten(t1);
        System.out.println(t1.val);
    }
}
