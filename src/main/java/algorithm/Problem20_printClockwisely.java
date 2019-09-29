package algorithm;

/**
 * Created by wqc on 2017/7/23.
 * 顺时针打印nxm矩阵
 *
 */
public class Problem20_printClockwisely {
    public void printClockwisely(int[][] mat,int n,int m)
    {
        //s打印圈数
        for(int s=0;s*2<m && s*2<n;s++)
        {
            int endx = n-s-1;
            int endy = m-s-1;
            //左--》右
            for(int i=s;i<=endx;i++)
            {
                System.out.println(mat[s][i]);
            }
            if(s<endy)
            {
                for(int i=s+1;i<endy;i++)
                {
                    System.out.println(mat[i][endx]);//上到下
                }
            }

            if(s<endx && s<endy)
            {
                for(int i = endx-1;i>=s;i--)
                {
                    System.out.println(mat[endy][i]);//右到左
                }
            }
            if(s<endx && s<endy-1)
            {
                for(int i=endy-1;i>s;i--)
                {
                    System.out.println(mat[i][s]);//下到上
                }
            }
        }
    }
}
