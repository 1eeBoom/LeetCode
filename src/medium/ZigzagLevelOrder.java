package medium;

/**
 * Created By LeeBoom On 2019/2/19 15:03
 */

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigzagLevelOrder {
    /**
     * 思路:
     * 与层次遍历相似,增加一个Boolean变量,用于指示当前层是正向输入还是逆向输出.
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // 使用队列来存储每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //使用布尔变量来存储当前的输出顺序是否为正序
        boolean positive = true;
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        while(!queue.isEmpty())
        {
            //得到当前层的节点总数
            int num = queue.size();
            List<Integer> list = new LinkedList<>();
            //将当前层的所有节点的值加入到链表中
            while(num > 0)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                {
                    ((LinkedList<TreeNode>) queue).add(node.left);
                }
                if(node.right != null)
                {
                    ((LinkedList<TreeNode>) queue).add(node.right);
                }
                num--;
            }
            //选择输出顺序
            if(positive) {
                res.add(list);
            }else {
                res.add(reverseList(list));
            }
            positive = !positive;
        }
        return res;
    }

    private List<Integer> reverseList(List<Integer> list) {
        List<Integer> list1 = new LinkedList<Integer>();
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);
        for (int i = list.size()-1; i >= 0; i--) {
            list1.add(nums[i]);
        }
        return list1;
    }


}
