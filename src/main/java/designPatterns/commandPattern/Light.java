package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 * 实例灯
 */
public class Light {
    public Light(){};

    public void on()
    {
        System.out.println("灯开了~");
    }
    public void off()
    {
        System.out.println("灯关了~");
    }
}
