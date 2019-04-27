package medium;

import struct.TreeNode;

/**
 * @author LeeBoom
 * @className BuildTree2
 * @description 106. 从中序与后序遍历序列构造二叉树
 * @date 2019-04-27 10:33
 **/
public class BuildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null ||inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return createNode(postorder, 0, postorder.length-1,
                inorder, 0, inorder.length-1);
    }
    public TreeNode createNode(int[] postorder, int postStart, int postEnd,
                               int[] inorder, int inStart, int inEnd) {
        //构建根节点
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        root.left = root.right = null;

        //子树中只有一个节点
        if(postStart == postEnd && inStart == inEnd ) {
            return root;
        }

        //找到中序遍历中根节点的所在下标
        int inRoot = inStart;
        while(inRoot <= inEnd && inorder[inRoot] != rootValue) {
            inRoot ++;
        }

        //中序遍历中不存在根节点
        if(inRoot > inEnd) {
            return null;
        }

        //中序遍历中找到根节点所在下标后
        //通过中序遍历，找到右子树长度，从而在后序遍历中找到右子树的开始下标
        int rightLen = inEnd - inRoot;
        //后序遍历中
        //右子树开始下标
        int rightStart = postEnd - rightLen;
        //右子树结束下标
        int rightEnd = postEnd-1;

        //构建右子树
        if(rightLen > 0) {
            root.right = createNode(postorder, rightStart, postEnd-1,
                    inorder, inRoot+1, inEnd);
        }
        //构建左子树
        if(rightLen < postEnd - postStart) {
            root.left = createNode(postorder, postStart, rightStart-1,
                    inorder, inStart, inRoot-1);
        }
        return root;
    }
    public static void main(String[] args){
        BuildTree2 buildTree2 = new BuildTree2();
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};

        buildTree2.buildTree(in,post);
    }
}
