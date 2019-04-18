package medium;

import struct.ListNode;

/**
 * @author LeeBoom
 * @className deleteDuplicates
 * @description TODO
 * @date 2019-04-18 11:37
 **/
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;

        ListNode end = head;
        ListNode node = head;
        while(node != null && node.next != null) {
            if(node.val == node.next.val) {

                while(node.next != null && node.val == node.next.val) {
                    node = node.next;
                    end = node;
                }
                if(pre == null) {
                    head = end.next;
                    node = head;
                } else {
                    pre.next = end.next;
                    node = end.next;
                }
            } else {
                pre = node;
                node = node.next;
            }
        }
        return head;
    }
}
