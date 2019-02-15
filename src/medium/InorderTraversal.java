package medium;

/**
 * Created By LeeBoom On 2019/2/15 21:30
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {
    /**
     * 递归算法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
         //递归算法
         List<Integer> list = new ArrayList<Integer>();
         if(root == null){
             return list;
         }
         list.addAll(inorderTraversal(root.left));
         list.add(root.val);
         list.addAll(inorderTraversal(root.right));
         return list;
    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return list;
        }
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                list.add(stack.peek().val);
                root = stack.pop().right;
            }
        }
        return list;
    }
}
