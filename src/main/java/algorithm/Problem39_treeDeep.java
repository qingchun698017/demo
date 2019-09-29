package algorithm;

/**
 * Created by wqc on 2017/8/13.
 * 二叉树的深度
 */
public class Problem39_treeDeep {
    public int treeDeep(BinaryTreeNode root)
    {
        if(root == null)
            return 0;
        int left = treeDeep(root.leftNode);
        int right = treeDeep(root.rightNode);
        return (left>right)?left+1:right+1;
    }
}
