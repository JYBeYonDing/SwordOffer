/**
 * 链表中倒数第k个节点
 */
public class Offer15 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(FindKthToTail(head,3).val);
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k<=0) {
            return null;
        }
        ListNode point1 = head;
        ListNode point2 = head;
        int index = 1;
        while (point2.next != null) {
            if (index < k) {
                point2 = point2.next;
                index++;
            } else {
                point2 = point2.next;
                point1 = point1.next;
            }
        }
        if (index < k) {
            return null;
        } else {
            return point1;
        }
    }

}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}