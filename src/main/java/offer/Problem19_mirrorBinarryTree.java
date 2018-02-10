package offer;

/**
 * Created by wqc on 2017/7/23.
 * 输入一个二叉树，输出它的镜像
 * 先序遍历树的每个结点，若遍历到的结点有子结点，则交换它的两个子结点。
 */
public class Problem19_mirrorBinarryTree {
    public void mirrorBinarryTree(BinaryTreeNode root)
    {
        if(root != null)
        {
            BinaryTreeNode temp = null;
            if(root.rightNode != null && root.leftNode != null)
            {
                temp = root.leftNode;
                root.leftNode = root.rightNode;
                root.rightNode = temp;
            }
            if(root.leftNode != null)
            {
                mirrorBinarryTree(root.leftNode);
            }
            if(root.rightNode != null)
            {
                mirrorBinarryTree(root.rightNode);
            }
        }
    }
}
