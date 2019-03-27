package medium;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created By LeeBoom On 2019/3/27 12:10
 */

/**
 * 题目：
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 思路：
 * 用深度遍历优先+回溯法。
 * 回溯法的精髓在于 状态回退。
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(res, new LinkedList<Integer>(), sum, root);
        return res;
    }

    /**
     * 回溯法：
     * 三个要点：
     * 1.递归函数的参数。主要包括：
     *   （1）用来保存每一次递归操作成功时的结果的全局变量res
     *    (2) 随着每一次递归操作改变的变量cur，target，list
     * @param res
     * @param list
     * @param target
     * @param cur
     */
    public void dfs(List<List<Integer>> res, LinkedList<Integer> list, int target, TreeNode cur) {
        //递归函数出口永远在第一句
        if (cur.val == target && cur.left == null && cur.right == null) {
            list.add(cur.val);
            res.add(new LinkedList<Integer>(list));
            //状态回退
            list.removeLast();
            return;
        }
        /**
         * 递归函数处理逻辑：
         * （1）执行相关赋值或其它操作
         * （2）然后转入下一次递归；
         * （3）如果下一次递归不能找到出口，则把之前相关赋值或其它操作重置为初始状态。
         *
         * PS:如果当前路径不正确，回退时一定要把之前改变的状态还原回去，否则会导致回退后的新路径不能遍历所有可能。
         */
        list.add(cur.val);
        if (cur.left != null) {
            dfs(res, list, target - cur.val, cur.left);
        }
        if (cur.right != null) {
            dfs(res, list, target - cur.val, cur.right);
        }
        //状态回退
        list.removeLast();
    }
}
