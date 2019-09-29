package algorithm;

/**
 * Created by wqc on 2017/7/23.
 * 输入两个二叉树A B，判断B是不是A的子树
 */
public class Problem18_hasSubTree {
    public boolean hasSubTree(BinaryTreeNode treeA,BinaryTreeNode treeB)
    {
        boolean result = false;
        if(treeA != null && treeB != null)
        {
            result = doTreeAhaveTreeB(treeA,treeB);
            if(!result)
            {
                result = hasSubTree(treeA.leftNode,treeB);
            }
            if(!result)
            {
                result = hasSubTree(treeB.rightNode,treeB);
            }
        }
        return result;
    }

    public boolean doTreeAhaveTreeB(BinaryTreeNode treeA,BinaryTreeNode treeB)
    {
        if(treeA == null)
        {
            return false;
        }
        if(treeB == null)
        {
            return true;
        }
        if(treeA.data != treeB.data)
        {
            return false;
        }
        return doTreeAhaveTreeB(treeA.leftNode,treeB.leftNode) &&
                doTreeAhaveTreeB(treeA.rightNode,treeB.rightNode);
    }
}
