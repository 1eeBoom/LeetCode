package medium;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By LeeBoom On 2019/3/29 10:10
 */
public class SumNumbers {
    /*回溯法*/
    public int sumNumbers(TreeNode root) {
        List<LinkedList<Integer>> res = new ArrayList<>();
        Iterator<LinkedList<Integer>> it = res.listIterator();
        int sum = 0;
        return numSum(it.next());
    }
    public void traceBack(List<LinkedList<Integer>> res, LinkedList<Integer> list, TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            res.add(new LinkedList<Integer>(list));
            list.removeLast();
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            traceBack(res,list,node.left);
        }
        if (node.right != null) {
            traceBack(res,list,node.right);
        }
        list.removeLast();
    }
    public int numSum (LinkedList<Integer> list) {
        int sum = 0;
        while(list.size() != 0){
            sum = (sum * 10) + list.poll();
        }
        return sum;
    }
}
