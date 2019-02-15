package medium;

/**
 * Created By LeeBoom On 2019/2/15 12:13
 */

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode node = headA;
        //计算链表长度用 node.next != null
        while(node.next != null){
            node = node.next;
            lenA++;
        }
        node = headB;
        while(node.next != null){
            node = node.next;
            lenB++;
        }
        if(lenA >= lenB){
            int diff = lenA-lenB;
            while (diff > 0){
                headA = headA.next;
                diff--;
            }
        }else {
            int diff = lenB-lenA;
            while (diff > 0){
                headB = headB.next;
                diff--;
            }
        }
        //对节点遍历 用 headA != null && headB != null
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
