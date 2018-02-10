package offer;

/**
 * Created by wqc on 2017/7/19.
 * 输入数字n，按顺序打印出从1到最大的n位进制数。如输入3 则打印出1-999
 */
public class Problem12_printToMaxOfNDigits {
    public void printToMaxOfNDigits(int n)
    {
        int[] array = new int[n];
        if(n <= 0)
            return;
        printArray(array,0);
    }

    private void printArray(int[] array, int n) {
        for(int i = 0;i<10;i++)
        {
            if(n!=array.length)
            {
                array[n] = i;
                printArray(array,n+1);
            }else{
                boolean isFirstNo0=false;
                for(int j = 0;j<array.length;j++)
                {
                    if(array[j] != 0)
                    {
                        System.out.println(array[j]);
                        if(!isFirstNo0)
                            isFirstNo0 = true;
                    }else{
                        if(isFirstNo0)
                        {
                            System.out.println(array[j]);
                        }
                    }
                    System.out.println();
                    return;
                }
            }
        }
    }
}
