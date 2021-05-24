package medium;
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// 最多调用 3 * 104 次 get 和 put
//
// Related Topics 设计
// 👍 1400 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import struct.Node;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

/**
 * LRU思路：
 * 1. LRU 结构上实现采用 双向链表+哈希表，其中以双向链表为主，哈希表为辅。
 * 2. 双向链表中，按使用顺序存储节点，靠近头部的节点是最近被使用的，靠近尾部的节点是最久未使用的。
 * 3. 哈希表中存储的则是关键字 Key 和对应的节点信息，通过 key 得知节点在双向链表中的具体位置
 * 4. 先使用 哈希表 找到被使用的节点，找到该节点在 双向链表 中的位置，然后将其移动到双向链表的头部。
 */
public class LRUCache {
    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.printList();

        lruCache.put(2,2);
        lruCache.printList();

        lruCache.put(3,3);
        lruCache.printList();

        lruCache.put(4,4);
        lruCache.printList();

        lruCache.get(2);
        lruCache.printList();

        lruCache.get(1);
        lruCache.printList();


    }

    class ListNode {
        //节点里也需要记录 Key的原因是因为由于哈希表的第一次寻址得到的是一个链表头结点
        //后续还要判断链表上的节点是否和目标节点相等，需要 key 判断
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    /**
     * 此处头结点和尾结点用于标记界限，但不是真正的节点，里面只有指针
     */
    private ListNode head, tail;

    /**
     * 哈希表用于快速查找到指定节点
     */
    private Map<Integer,ListNode> map;

    /**
     * LRU 初始化
     * 1. size = 0
     * 2. 实例化伪头尾节点
     * 3. 初始化最大容量
     * 4. 初始化 Map
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        /**
         * 初始化伪头结点和伪尾结点
         */
        head = new ListNode();
        tail = new ListNode();

        head.prev = null;
        head.next = tail;

        tail.prev = head;
        tail.next = null;

        map = new HashMap<>(capacity);

    }

    // int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。

    /**
     * 先使用 哈希表 找到被使用的节点，找到该节点在 双向链表 中的位置，然后将其移动到双向链表的头部。
     *
     * @param key
     * @return
     */
    public int get(int key) {
        ListNode node = map.get(key);

        if(node == null) {
            return -1;
        }else {
            moveNodeToHead(node);
            return node.value;
        }
    }

    /**
     * 1.如果存在，则替换，并移动到头部
     * 2. 如果不存在则插入，并移动到头部。插入后如果大小大于容量则移除尾巴节点。
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            moveNodeToHead(node);
        }else {
            ListNode node = new ListNode(key,value);
            map.put(key,node);
            addNodeToHead(node);
            size++;
            while (size > capacity) {
                removeTailNode();
                size--;
            }
        }
    }

    /**
     * 删除尾巴节点，分为两步
     * 1. 将尾巴节点断开与前节点和伪尾结点的连接
     * 2. 将尾巴节点的前节点和伪尾结点相连
     * 3. 从 map 中将尾巴节点删除，并置为null
     */
    private void removeTailNode() {
        ListNode removedNode = tail.prev;
        removedNode.prev.next = tail;
        tail.prev = removedNode.prev;
        removedNode.prev = null;
        removedNode.next = null;
        map.remove(removedNode.key);
    }

    /**
     * 将节点加到到头结点，分为两个步骤
     * 1. 将节点和伪头结点和头结点先搭上连线
     * 2. 断开伪头结点和头结点之间的连线，将节点塞到中间并连接
     * @param node
     */
    private void addNodeToHead(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 将节点移动到头结点，分为两个步骤
     * 1、断开当前节点的连接
     * 2、把节点加到头部
     * 注意：head.next 应该是最后断掉的
     *
     * @param node
     */
    private void moveNodeToHead(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        addNodeToHead(node);
    }

    private void printList() {
        ListNode node = head.next;
        while (node.next != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
