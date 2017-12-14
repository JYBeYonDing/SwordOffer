/**
 * 反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素
 */
public class Offer16 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(ReverseList(head).next.next.val);
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head.next;
        head.next = null;
        ListNode c = b.next;
        while (c != null) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        head = b;
        b.next = a;
        return head;
    }
}
