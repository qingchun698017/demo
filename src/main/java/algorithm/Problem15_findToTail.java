package algorithm;

/**
 * Created by wqc on 2017/7/22.
 * 输入头结点，和数k，求链表中倒数第k个结点
 *为了能够只遍历一次就能找到倒数第k个节点，可以定义两个指针：

 　　（1）第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持不动；

 　　（2）从第k步开始，第二个指针也开始从链表的头指针开始遍历；

 　　（3）由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，
        第二个指针（走在后面的）指针正好是倒数第k个结点。

 　　举一反三：当我们用一个指针遍历链表不能解决问题的时候，可以尝试用两个指针来遍历链表。
 可以让其中一个指针遍历的速度快一些（比如一次在链表上走两步），或者让它先在链表上走若干步。


 */
public class Problem15_findToTail {
    public Node findToTail(Node head,int k)
    {

        if(head == null || k == 0)
        {
            return null;
        }

        Node result = null;
        Node headListNode = head;
        for(int i = 0;i < k-1;i++)
        {
            if(headListNode.nextNode != null)
            {
                headListNode = headListNode.nextNode;
            }else{
                return null;
            }
        }

        result = head;
        while(headListNode != null)
        {
            result = result.nextNode;
            headListNode = headListNode.nextNode;
        }
        return result;
    }
}
