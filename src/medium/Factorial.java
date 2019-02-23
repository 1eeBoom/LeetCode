package medium;

/**
 * Created By LeeBoom On 2019/2/17 13:24
 */

import struct.TreeNode;

/**
 * 递归
 */
public class Factorial {
    /**
     * 阶乘问题
     * n!= n * (n-1)!
     * 0! = 1
     * @param n
     * @return
     */
    int factorial(int n)
    {
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }

    /**
     * 汉诺塔问题
     * 有n个大小不等的盘子放在一个塔A上面，自底向上按照从大到小的顺序排列。
     * 要求将所有n个盘子搬到另一个塔C上面，可以借助一个塔B中转，但是要满足任何时刻大盘子不能放在小盘子上面。
     * 基本思想分三步，
     * 1.先把上面的N-1个盘子经C移到B，
     * 2.然后将最底下的盘子移到C，
     * 3.再讲B上面的N-1个盘子经A移动到C。总的时间复杂度f(n)=2f(n-1)+1，所以f(n)=2^n-1。
     * @param a
     * @param b
     * @param c
     * @param n
     */
    void hano(char a, char b, char c, int n)
    {
        if(n > 0) {
            // 1.先把上面的N-1个盘子经C移到B，
            hano(a, c, b, n-1);
            // 2.然后将最底下的盘子移到C，
            move(a,c);
            //  3.再讲B上面的N-1个盘子经A移动到C。总的时间复杂度f(n)=2f(n-1)+1，所以f(n)=2^n-1。
            hano(b, a, c, n-1);
        }
    }

    private void move(char a, char c) {
        System.out.println("move " + a + " -> " + c);
    }

    /**
     *求二叉树的深度
     * @param node
     * @return
     */
    int depth(TreeNode node){
        if(node == null)
        {
            return 0;
        }
        return Math.max(depth(node.left)+1,depth(node.right)+1);
    }
}
