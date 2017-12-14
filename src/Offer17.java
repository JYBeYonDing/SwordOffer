/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class Offer17 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode head = Merge(list1, list2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode head = null;

        if (head1.val <= head2.val) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        ListNode temp = head;
        while (head1!= null && head2!= null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                temp = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = head2;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            temp.next = head2;
        } else {
            temp.next = head1;
        }

        return head;
    }
}
