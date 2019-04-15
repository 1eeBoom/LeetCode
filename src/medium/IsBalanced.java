package medium;

import struct.TreeNode;

/**
 * @author LeeBoom
 * @className IsBalanced
 * @description 110. 平衡二叉树
 * @date 2019-04-14 11:46
 **/
public class IsBalanced {
    private class ReturnNode {
        boolean isB;
        int depth;
        //构造方法
        public ReturnNode(int depth,boolean isB) {
            this.isB = isB;
            this.depth = depth;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return isBST(root).isB;
    }
    public ReturnNode isBST(TreeNode root) {
        if(root == null) {
            return new ReturnNode(0,true);
        }

        ReturnNode left = isBST(root.left);
        ReturnNode right = isBST(root.right);

        if (left.isB == true && right.isB == true && Math.abs(left.depth - right.depth) <= 1) {
            return new ReturnNode(Math.max(left.depth, right.depth) + 1, true);
        } else {
            return new ReturnNode(0,false);
        }

    }
}
