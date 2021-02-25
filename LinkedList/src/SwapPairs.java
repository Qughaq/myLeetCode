public class SwapPairs {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode left = temp.next;
            ListNode right = temp.next.next;
            temp.next = right;
            left.next = right.next;
            right.next = left;
            temp = left;
        }
        return dummyHead.next;
    }
}
