/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Offer37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode temp1 = pHead1;
        int len1 = 1;
        while (temp1.next != null) {
            len1++;
            temp1 = temp1.next;
        }

        ListNode temp2 = pHead2;
        int len2 = 1;
        while (temp2.next != null) {
            len2++;
            temp2 = temp2.next;
        }

        temp1 = pHead1;
        temp2 = pHead2;

        int lenDif = len1 - len2;
        if (lenDif > 0) {
            while (lenDif != 0) {
                temp1 = temp1.next;
                lenDif--;
            }
        } else {
            while (lenDif != 0) {
                temp2 = temp2.next;
                lenDif++;
            }
        }

        while (temp1 != temp2 && temp1!=null && temp2!=null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (temp1 == null || temp2 == null) {
            return null;
        }else{
            return temp1;
        }

    }
}
