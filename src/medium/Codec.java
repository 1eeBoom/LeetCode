package medium;


import struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的
 */


public class Codec {

    // Encodes a tree to a single string.
    public  String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                list.add("null");
            }else {
                list.add(String.valueOf(node.val));
                ((LinkedList<TreeNode>) queue).add(node.left);
                ((LinkedList<TreeNode>) queue).add(node.right);
            }
        }
        //删除叶子节点的空指针.
        while("null".equals(list.get(list.size()-1))){
            ((LinkedList<String>) list).removeLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (String s:list)
        {
            stringBuilder.append(s);
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)){
            return null;
        }
        String[] nums = data.substring(1,data.length()-1).split(",");
        //已在树上节点队列
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        //
        ((LinkedList<TreeNode>) queue).add(root);
        //当前待分配节点
        int index = 0;
        //左孩子节点标志
        boolean isLeftChild = true;
        for (int i = 1; i < nums.length; i++) {
            if(!"null".equals(nums[i])){
                //分配新节点
                TreeNode node = new TreeNode(Integer.parseInt(nums[i]));
                if(isLeftChild){
                    ((LinkedList<TreeNode>) queue).get(index).left = node;
                }else {
                    ((LinkedList<TreeNode>) queue).get(index).right = node;
                }
                ((LinkedList<TreeNode>) queue).add(node);
            }
            if(!isLeftChild){
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = null;
        node2.right = null;
        node3.left = node4;
        node3.right = node5;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));