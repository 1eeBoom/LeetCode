package medium;

import struct.TreeNode;

/**
 * Created By LeeBoom On 2019/2/23 15:48
 */

/**
 *  从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
        {
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder,0, inorder.length-1);
    }

    /**
     * 递归函数:根据前序遍历序列和中序遍历序列构建左子树和右子树,直到序列开始下标和结束下标相遇
     * @param preorder 前序遍历序列
     * @param startPreorder 前序遍历序列开始下标
     * @param endPreorder 前序遍历序列结束下标
     * @param inorder 中序遍历虚列
     * @param startInorder 中序遍历序列开始下标
     * @param endInorder 中序遍历序列结束下标
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int startPreorder, int endPreorder,
                                     int[] inorder, int startInorder, int endInorder){
        //根据前序遍历序列的第一个数字创建根节点
        //前序遍历序列的第一个数字是根节点的值
        int rootValue = preorder[startPreorder];
        TreeNode root = new TreeNode(rootValue);
        root.left = root.right = null;

        //递归中止条件
        if(startInorder == endInorder && startPreorder == endPreorder)
        {
            return root;
        }

        //递归逻辑
        //在中序遍历序列中找到根节点的值
        int rootInoreder = startInorder;
        while(rootInoreder <= endInorder && inorder[rootInoreder] != rootValue)
        {
            ++rootInoreder;
        }
        //如果没在中序遍历序列中找到对应根节点的值的节点,则返回null
        if(rootInoreder > endInorder || inorder[rootInoreder] != rootValue){
            return null;
        }

        //中序遍历序列中,所有在根节点左边的节点的长度为左子树长度
        int leftLength = rootInoreder - startInorder;
        //根据得到的左子树长度,在前序遍历序列中找到左子树结束节点下标
        int leftPreorderEnd = startPreorder + leftLength;
        if(leftLength > 0)
        {
            //如果存在左子树,构建左子树
            root.left = buildTree(preorder,startPreorder+1, leftPreorderEnd, inorder, startInorder, rootInoreder-1);
        }
        if(leftLength < endPreorder - startPreorder)
        {
            //如果存在右子树,构建右子树
            root.right = buildTree(preorder, leftPreorderEnd+1, endPreorder, inorder, rootInoreder+1, endInorder);
        }
        return root;
    }
}
