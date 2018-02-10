package offer;

/**
 * Created by wqc on 2017/7/18.
 * 输入n，求斐波那契数列的第n项
 * F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
 */
public class Fibonacci {
    public long fibonacci(int n)
    {
        long result = 0;
        long preOne = 0;
        long preTwo = 1;
        if(n == 0)
        {
            return preOne;
        }
        if(n == 1)
        {
            return preTwo;
        }

        for(int i = 2;i<=n;i++)
        {
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return  result;
    }
}
