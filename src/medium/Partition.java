package medium;

import struct.ListNode;

/**
 * @author LeeBoom
 * @className Partition
 * @description [86\. 分隔链表](https://leetcode-cn.com/problems/partition-list/)
 * @date 2019-04-20 22:58
 **/
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        //存储大于等于x的第一个节点的前一个节点
        ListNode start = null ;
        //存储前一个节点
        ListNode pre = null;

        ListNode headNode = head;

        ListNode node = head;
        while (head != null) {
            if(head.val < x) {
                break;
            }
            head = head.next;
        }
        if(head == null) {
            return node;
        }
        while(node != null) {
            if (node.val >= x) {
                pre = node;
                node = node.next;
                break;
            } else {
                start = node;
                node = node.next;
            }
        }

        while (node != null) {
            if(node.val < x) {
                //前一个节点的next指向当前节点的next
                pre.next = node.next;

                if(start == null) {
                    start = node;
                    start.next = headNode;
                } else {
                    //当前节点的next指向第一个大于等于x的节点
                    node.next = start.next;
                    //最后一个小于x的节点指向当前节点
                    start.next = node;

                    start = start.next;
                }
                node = pre.next;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return head;
    }
}
