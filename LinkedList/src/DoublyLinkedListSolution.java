public class DoublyLinkedListSolution {
    class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int x) {
            val = x;
        }
    }


    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num <<= 1;
            num += head.val;
            head = head.next;
        }
        return num;
    }

    public DoublyListNode mergeTwoLists(DoublyListNode l1, DoublyListNode l2) {

        return null;
    }
}
