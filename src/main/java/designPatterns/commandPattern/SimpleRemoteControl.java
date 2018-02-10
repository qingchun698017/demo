package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 * 简单遥控器：一个按钮
 */
public class SimpleRemoteControl {
    Command command;
    SimpleRemoteControl() {}

    public void setCommand(Command command)
    {
        this.command = command;
    }

    //按钮按下灯就亮
    public void buttonWasPressed()
    {
        command.execute();
    }
}
