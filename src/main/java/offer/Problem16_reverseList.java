package offer;

/**
 * Created by wqc on 2017/7/22.
 * 输入有一个链表头结点，反转该链表，输出反转后的链表头结点
 */
public class Problem16_reverseList {
    public Node reverseList(Node head)
    {
        Node preNode = null;
        Node nowNode = head;
        Node reverseHead = null;
        while(nowNode.nextNode != null)
        {
            Node nextNode = nowNode.nextNode;
            nowNode.nextNode = preNode;
            preNode = nowNode;
            nowNode = nextNode;

        }
        return nowNode;
    }
}
