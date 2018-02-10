package offer;

/**
 * Created by wqc on 2017/8/13.
 * 字符串排序列一串字符串，输出该字符串中字符的所有排列
 * 输入
 */
public class Problem28_prenutation {
    public static void main(String[] args) {
        String s="sddda";
        prenutation(s.toCharArray(),0,s.length()-1);
    }
    public static void prenutation(char[] strArr,int start,int end)
    {
        char temp;
        if(strArr.length == 0)
        {
            return;
        }
        if(start == end)
        {
            for (char c : strArr) {
                System.out.println(c);
            }
        }else{
            for(int i = start;i<=end;i++)
            {
                temp = strArr[start];
                strArr[start] = strArr[i];
                strArr[i] = temp;

                prenutation(strArr,start+1,end);

                temp = strArr[start];
                strArr[start] = strArr[i];
                strArr[i] = temp;
            }
        }
    }
}
