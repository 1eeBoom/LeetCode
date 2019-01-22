package medium;


/**
 *  两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        /**
         * 将两个链表长度计算出来.
         */
        while(node1 != null){
            len1++;
            node1 = node1.next;
        }
        while(node2 != null){
            len2++;
            node2 = node2.next;
        }

        /**
         * 使用O(C)的额外空间
         */
        ListNode node = null;
        int len = 0;

        /**
         * 将较长的链表作为改造的链表
         */
        if(len1 >= len2){
            node = l1;
            len = len1;
        }else {
            node = l2;
            len = len2;
        }
        /**
         * 记录下较长链表的头部,作为返回值
         */
        ListNode head = node;

        /**
         * 申请长度为len+1的数组,用于记录第i位相加产生的进位
         */
        int[] add = new int[len+1];

        /**
         * 将对应链表节点上的数字以及前一位产生的进位相加,产生对应位上的结果和进位
         */
        for (int i = 1; i <= len; i++) {
            int num = 0;
            if(l1 == null){
                num = l2.val+add[i-1];
                l2 = l2.next;
            }else if(l2 == null){
                num = l1.val+add[i-1];
                l1 = l1.next;
            }else {
                num = l1.val+l2.val+add[i-1];
                l1 = l1.next;
                l2 = l2.next;
            }
            node.val = num % 10;
            add[i] = num /10;

            /**
             * 最后需要特殊判断下是否会给较长的链表额外产生进位.
             */
            if(i == len && add[i] != 0){
                node.next = new ListNode(add[i]);
            }else {
                node = node.next;
            }
        }
        return head;
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        //创建一个新的空的头结点,用于存储计算结果
        ListNode node = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = node;
        int carry = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        return node.next;
    }
}
