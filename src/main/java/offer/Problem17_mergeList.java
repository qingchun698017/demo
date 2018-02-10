package offer;

/**
 * Created by wqc on 2017/7/23.
 * 输入两个递增的链表，合并两个链表，合并后的链表也递增
 */
public class Problem17_mergeList {
    public Node mergeList(Node head1,Node head2)
    {
        if(head1 == null)
        {
            return head2;
        }

        if(head2 == null)
        {
            return head1;
        }

        Node mergeHead = null;
        if(head1.data < head2.data)
        {
            mergeHead = head1;
            mergeHead.nextNode = mergeList(head1.nextNode,head2);
        }else{
            mergeHead = head2;
            mergeHead.nextNode = mergeList(head2.nextNode,head1);
        }

        return mergeHead;
    }
}
