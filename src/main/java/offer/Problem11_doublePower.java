package offer;

/**
 * Created by wqc on 2017/7/19.
 * 求base的exponent次方。不使用库函数，同时不考虑大数问题
 */
public class Problem11_doublePower {
    public double power(double base,int exponent) throws Exception
    {
        double result = 0.0;
        if(equal(base,0.0) && exponent < 0)
        {
            throw new Exception("0的负数次幂没有意义");
        }

        if(exponent < 0)
        {
            result = 1.0/powerWithExpoment(base,-exponent);
        }else{
            result = powerWithExpoment(base,exponent);
        }
        return result;
    }

    private double powerWithExpoment(double base, int exponent) {
        if(exponent == 0)
        {
            return 1;
        }
        if(exponent == 1)
        {
            return base;
        }

        double result = 1.0;
        for(int i = 1;i<=exponent;i++)
        {
            result = result * base;
        }
        return result;
    }

    private boolean equal(double num1, double num2) {
        if((num1 - num2 > -0.0000000001)&&num1-num2<0.0000000000000000001)
        {
            return true;
        }else{
            return false;
        }
    }
}
