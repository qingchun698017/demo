package offer;

/**
 * Created by wqc on 2017/7/22.
 * 给点一个单链表的头结点和其中一个结点，在0（1）时间内删除该结点
 */
public class Problem13_deleteNode {
    /**
     * 三种情况：1、给定的结点是头结点 2、给定的结点是尾结点  3、给定的结点在中间
     */
    public void deleteNode(Node head,Node deleteNode)
    {
        if(head == null || deleteNode == null)
        {
            return;
        }
        //删除头结点
        if(head == deleteNode)
        {
            head = null;
        }else{
            if(deleteNode.nextNode == null)//删除尾结点
            {
                Node pointNode = head;
                while (pointNode.nextNode.nextNode != null)
                {
                    pointNode = pointNode.nextNode;
                }
                pointNode.nextNode = null;
            }else{
                deleteNode.data = deleteNode.nextNode.data;
                deleteNode.nextNode = deleteNode.nextNode.nextNode;
            }
        }


    }
}
