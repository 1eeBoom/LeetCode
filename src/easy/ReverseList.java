package easy;

import struct.ListNode;

import java.util.List;

/**
 * Created By LeeBoom On 2019/2/23 14:21
 */

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //用于备份head.next指针域
        ListNode next = null;
        //用于指向新链表的结尾
        ListNode newHead = null;
        while(head != null )
        {
            //备份head.next指针域
            next = head.next;
            //修改head.next指针域
            head.next = newHead;
            //修改newHead为head,为下一次循环的更新做准备
            newHead = head;
            //更新head
            head = next;
        }
        return newHead;
    }
}
