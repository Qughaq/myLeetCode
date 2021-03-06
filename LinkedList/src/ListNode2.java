public class ListNode2 {
    private Node head;
    private Node tail;
    private int size;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public ListNode2() {
        head = new Node(0);
        tail = head;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || index < 0)
            return -1;
        Node cur = head;
        for (int i = 0; i <= index; i++)
            cur = cur.next;
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node temp = head.next;
        head.next = new
                Node(val);
        head.next.next = temp;
        size++;//计数
        if (size == 1)
            tail = head.next;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        tail.next = new
                Node(val);
        tail = tail.next;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        Node cur = head;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        Node temp = cur.next;
        cur.next = new
                Node(val);
        if (index == size)
            tail = cur.next;
        cur.next.next = temp;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0)
            return;
        Node cur = head;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.next = cur.next.next;
        size--;
        if (cur.next == null)
            tail = cur;
    }
}
