package offer;

/**
 * Created by wqc on 2017/7/17
 * 实现一个函数，把字符串中的每个空格替换成“%20”
 *
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        String s ="We are happy";
        System.out.println(replaceBlank(s));
    }

    private static String replaceBlank(String s) {
        if(s == null)
        {
            return null;
        }

        StringBuffer outputBuffer = new StringBuffer();
        for(int i = 0;i<s.length();i++)
        {
            if("".equals(s.charAt(i)) )
            {
                outputBuffer.append("%");
                outputBuffer.append("2");
                outputBuffer.append("0");
            }else{
                outputBuffer.append(String.valueOf(s.charAt(i)));
            }
        }
        return new String(outputBuffer);
    }
}
