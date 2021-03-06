public class SinglyLinkedListSolution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置dummyHead是这一类问题的一般做法
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++)
            fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode p = head;
        while (true) {
            // 保留前 m 个, 那得停留在 m - 1 这个位置, 方便删除
            for (int i = 0; i < m - 1 && p != null; i++)
                p = p.next;
            // 直接跳过接下来的 n 个位置
            for (int i = 0; i < n && p != null && p.next != null; i++)
                p.next = p.next.next;
            // 到末尾了, 就跳出
            if (p == null)
                break;
            // 否则往后走
            p = p.next;
        }
        return head;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode smallHead = small;
        ListNode large = new ListNode();
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        // 形成环形单链表，然后旋转链表
        tail.next = head;
        for (int step = 1; step <= len - k % len; step++)
            tail = tail.next;
        head = tail.next;
        tail.next = null;
        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head != null) return null;
        ListNode sortedHeadPrev = new ListNode(0);
        ListNode lastSorted = head;
        ListNode curr = head.next;
        sortedHeadPrev.next = head;
        while (curr != null) {
            if (lastSorted.val <= curr.val)
                lastSorted = lastSorted.next;
            else {
                ListNode prev = sortedHeadPrev;
                while (prev.next.val <= curr.val)
                    prev = prev.next;
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return sortedHeadPrev.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultHead = new ListNode(0);
        ListNode temp = resultHead;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(carry % 10);
            temp = temp.next;
            carry /= 10;
        }
        if (carry == 1)
            temp.next = new ListNode(1);
        return resultHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        // 把还在非空的剩余部分接上来
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null)
//            return null;
//        head.next = removeElements(head.next, val);
//        if (head.val == val)
//            return head.next;
//        else
//            return head;
//    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead, curr = head;
        while (curr != null) {
            if (curr.val == val)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
        return dummyHead.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null)
            return false;
        do {
            if (fast.next == null || fast.next.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);
        return true;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode counter = head;
                while (counter != null) {
                    if (counter == slow)
                        return counter;
                    counter = counter.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }
}