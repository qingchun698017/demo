package offer;

/**
 * Created by wqc on 2017/8/12.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。比如输入下图中左边的二叉搜索树，则输出转换之后的排序双向链表。
 *
 * 在二叉树中，每个结点都有两个指向子结点的指针。在双向链表中，每个结点也有两个指针，它们分别指向前一个结点和后一个结点。
 * 由于要求转换之后的链表是排好序的，我们可以中序遍历树中的每一个结点，
 * 这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每一个结点.
 *
 * 按照中序遍历的顺序，当我们遍历转换到根结点（值为10的结点）时，它的左子树已经转换成一个排序的链表了，
 * 并且处在链表中的最后一个结点是当前值最大的结点。我们把值为8的结点和根结点链接起来，此时链表中的最后一个结点就是10了。
 * 接着我们去遍历转换右子树，并把根结点和右子树中最小的结点链接起来。
 */
public class Problem27_convertNode {

    public BinaryTreeNode Convert(BinaryTreeNode node)
    {
        BinaryTreeNode lastNode = null;
        ConvertNode(node,lastNode);
        BinaryTreeNode headNode = node;
        while(headNode != null && headNode.leftNode != null)
        {
            headNode = headNode.leftNode;
        }
        return headNode;
    }

    private void ConvertNode(BinaryTreeNode node, BinaryTreeNode lastNode) {
        if(node == null)
        {
            return;
        }
        BinaryTreeNode currentNode = node;
        //遍历左子树
        if(currentNode.leftNode != null)
        {
            ConvertNode(currentNode.leftNode,lastNode);
        }

        //连接根节点
        currentNode.leftNode = lastNode;
        if(lastNode != null)
        {
            lastNode.rightNode = currentNode;
        }
        lastNode = currentNode;
        //遍历右子树
        if(currentNode.rightNode != null)
        {
            ConvertNode(currentNode.rightNode,lastNode);
        }


    }
}
