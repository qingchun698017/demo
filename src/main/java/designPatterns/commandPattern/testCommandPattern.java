package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 * 命令模式：将请求分装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。
 * 命令模式也支持可撤销操作
 */
public class testCommandPattern {

    public static void main(String[] args) {
        Light light = new Light();
        Command onCommand = new LightOnCommand(light);
        Command offCommand = new LightOffCommand(light);
        RemoteControl rc = new RemoteControl();
        rc.setCommand(3,onCommand,offCommand);

        rc.onButtonWasPushed(3);
        rc.offButtonWasPushed(3);
        rc.undoButtonWasPushed();
    }
}
