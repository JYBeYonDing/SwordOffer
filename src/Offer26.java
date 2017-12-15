import javax.management.relation.RelationNotFoundException;
import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Offer26 {

    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);

        pHead.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        pHead.random = c;
        b.random = e;
        d.random = b;

        Clone(pHead);

    }
    public static RandomListNode Clone(RandomListNode pHead)
    {
        //以空间换时间
//        if (pHead == null) {
//            return null;
//        }
//
//        RandomListNode head = new RandomListNode(pHead.label);
//        RandomListNode temp = head;
//        RandomListNode pTemp = pHead;
//
//        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
//        map.put(pHead, head);
//        //第一步，按照next指针复制节点
//        while (pTemp.next != null) {
//            temp.next = new RandomListNode(pTemp.next.label);
//            temp = temp.next;
//            pTemp = pTemp.next;
//            map.put(pTemp, temp);
//        }
//
//        temp = head;
//        pTemp = pHead;
//        while (pTemp.next != null) {
//            temp.random = map.get(pTemp.random);
//            temp = temp.next;
//            pTemp = pTemp.next;
//        }
//
//        return head;

        //不以空间换时间实现O(n)复杂度
        // 第一步把N'放在N之后
        cloneNodes(pHead);
        // 第二步复制随机索引
        cloneRandom(pHead);
        // 第三步拆分
        RandomListNode head = split(pHead);

        return head;
    }

    private static RandomListNode split(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode pTemp = pHead;
        RandomListNode head = pHead.next;
        RandomListNode temp = head;
        while (temp != null) {
            pTemp.next = pTemp.next.next;
            pTemp = pTemp.next;

            if (temp.next != null) {
                temp.next = temp.next.next;
                temp = temp.next;
            } else {
                break;
            }
        }

        return head;
    }

    private static void cloneRandom(RandomListNode pHead) {
        if (pHead == null) {
            return;
        }
        RandomListNode pTemp = pHead;
        while (pTemp != null) {
            if (pTemp.random != null) {
                pTemp.next.random = pTemp.random.next;
            }
            pTemp = pTemp.next.next;
        }
    }

    private static void cloneNodes(RandomListNode pHead) {
        if (pHead == null) {
            return;
        }

        RandomListNode pTemp = pHead;
        while (pTemp != null) {
            RandomListNode temp = new RandomListNode(pTemp.label);
            temp.next = pTemp.next;
            pTemp.next = temp;

            pTemp = temp.next;
        }
    }

    
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}