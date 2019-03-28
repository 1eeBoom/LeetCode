package medium;

/**
 * Created By LeeBoom On 2019/3/28 21:24
 */

import struct.Node;

/**
 * 题目：
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 *
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 *
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 思路：
 * 深度遍历优先搜索。这题卡了很久，主要是没有考虑到特殊情况。
 */
public class Connect2 {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }
    public void dfs(Node root) {
        if(root == null){
            return;
        }
        Node node = root.next;
        /**
         * 一直找到当前节点的最右端的最右子节点
         *
         */
        // 未考虑到的情况，左叶子节点和右叶子节点之间隔了多个节点。
        //                  o root
        //                 / \
        //     root.left  o —— o  root.right
        //               /    / \
        //              o —— o   o
        //             /        / \
        //            o        o   o
        while (node != null) {
            if(node.left != null) {
                node = node.left;
                break;
            }
            if(node.right != null) {
                node = node.right;
                break;
            }
            node = node.next;
        }
        if(root.right != null) {
            root.right.next = node;
        }
        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            }else {
                root.left.next = node;
            }
        }
        // 先确保 root.right 下的节点的已完全连接，因 root.left 下的节点的连接
        // 需要 root.left.next 下的节点的信息(一定情况下的root.right)，若 root.right 下的节点未完全连
        // 接（即先对 root.left 递归），则 root.left.next 下的信息链不完整，将
        // 返回错误的信息。
        dfs(root.right);
        dfs(root.left);
    }
}
