package medium;

import struct.ListNode;

/**
 * @author LeeBoom
 * @className RotateRight
 * @description 61. 旋转链表
 * @date 2019-04-17 16:20
 **/
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int size = 0;
        ListNode node = head;
        while(node != null) {
            node = node.next;
            size++;
        }
        int count = k % size;
        for(int i = 0 ; i < count; i++) {
            head = oneStep(head);
        }
        return head;
    }
    public ListNode oneStep(ListNode head) {
        ListNode endNode = head;
        ListNode pre = head;
        while(endNode.next != null) {
            pre = endNode;
            endNode = endNode.next;
        }
        pre.next = null;
        endNode.next = head;
        return endNode;

    }
}
