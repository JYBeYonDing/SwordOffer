import java.util.ArrayDeque;
import java.util.ArrayList;

public class Offer5 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) {
            return arrayList;
        }


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }


        while (!stack.isEmpty()) {
            arrayList.add(stack.poll());
        }

        return arrayList;
    }

}
