package medium;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LeeBoom
 * @className GenerateTrees
 * @description 95. 不同的二叉搜索树 II
 * @date 2019-04-25 23:25
 **/
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTree(1, n);
    }
    public List<TreeNode> generateTree(int start, int end) {
        LinkedList<TreeNode> res =new LinkedList<TreeNode>();
        if(start > end) {
            res.add(null);
            return res;
        }
        for(int rootValue = start; rootValue <= end; rootValue++) {
            for(TreeNode leftNode : generateTree(start, rootValue - 1)) {
                for(TreeNode rightNode : generateTree(rootValue + 1, end)) {
                    TreeNode root  = new TreeNode(rootValue);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
