package algorithm;

import java.util.Arrays;

/**
 * Created by wqc on 2017/7/17.
 * 重建二叉树
 * 输入二叉树的前序遍历和中序遍历的结果。重建出该二叉树。
 * 假设前序遍历和中序遍历结果中都不包含重复的数字
 * 前序遍历：
 1.访问根节点
 2.前序遍历左子树
 3.前序遍历右子树
 中序遍历：
 1.中序遍历左子树
 2.访问根节点
 3.中序遍历右子树
 后序遍历：
 1.后序遍历左子树
 2.后序遍历右子树
 3.访问根节点
 */
public class RebuildBinaryTreeNode {

    public static void main(String[] args) {
        int[] preSort = {1,2,4,7,3,5,6,8};
        int[] inSort = {4,7,2,1,5,3,8,6};
        try {
            BinaryTreeNode root = constructCore(preSort,inSort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BinaryTreeNode constructCore(int[] preSort, int[] inSort) throws Exception {
        if(preSort == null || inSort == null)
        {
            return null;
        }

        if(preSort.length != inSort.length)
        {
            throw new Exception("长度不一样，非法的输入");
        }

        BinaryTreeNode root = new BinaryTreeNode();
        /**
         * PreOrder:         GDAFEMHZ
         InOrder:            ADEFGHMZ
         我们如何还原这颗二叉树，并求出他的后序遍历？



         我们基于一个事实：中序遍历一定是 { 左子树中的节点集合 }，root，{ 右子树中的节点集合 }，前序遍历的作用就是找到每颗子树的root位置。

         算法1
         输入：前序遍历，中序遍历
         1、寻找树的root，前序遍历的第一节点G就是root。
         2、观察前序遍历GDAFEMHZ，知道了G是root，剩下的节点必然在root的左或右子树中的节点。
         3、观察中序遍历ADEFGHMZ。其中root节点G左侧的ADEF必然是root的左子树中的节点，G右侧的HMZ必然是root的右子树中的节点，root不在中序遍历的末尾或开始就说明根节点的两颗子树都不为空。
         4、观察左子树ADEF，按照前序遍历的顺序来排序为DAFE，因此左子树的根节点为D，并且A是左子树的左子树中的节点，EF是左子树的右子树中的节点。
         5、同样的道理，观察右子树节点HMZ，前序为MHZ，因此右子树的根节点为M，左子节点H，右子节点Z。

         观察发现，上面的过程是递归的。先找到当前树的根节点，然后划分为左子树，右子树，然后进入左子树重复上面的过程，然后进入右子树重复上面的过程。
         */
        for (int i : inSort) {
            if(inSort[i] == preSort[0])
            {
                root.value = inSort[i];
                System.out.println(root.value);
                //copyOfRange(int[] original, int from, int to)
                root.leftNode = constructCore(Arrays.copyOfRange(preSort,1,i+1),
                        Arrays.copyOfRange(inSort,0,i));
                root.rightNode = constructCore(Arrays.copyOfRange(preSort,i+1,preSort.length),
                        Arrays.copyOfRange(inSort,i+1,inSort.length));
            }
        }
        return root;

    }
}
