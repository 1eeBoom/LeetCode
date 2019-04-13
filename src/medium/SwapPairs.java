package medium;

import struct.ListNode;

/**
 * @author LeeBoom
 * @className SwapPairs
 * @description 24. 两两交换链表中的节点
 * @date 2019-04-13 23:18
 **/
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
