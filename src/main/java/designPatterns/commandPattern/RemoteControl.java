package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 * 遥控器：7个按钮
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;
    //构造器中实例化7个开关按钮
    public RemoteControl()
    {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for(int i =0;i<7;i++)
        {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int i,Command on,Command off)
    {
        onCommands[i] = on;
        offCommands[i] = off;
    }

    public void onButtonWasPushed(int i)
    {
        onCommands[i].execute();
        undoCommand = onCommands[i];
    }

    public void offButtonWasPushed(int i)
    {
        offCommands[i].execute();
        undoCommand = offCommands[i];
    }

    public void undoButtonWasPushed()
    {
        undoCommand.undo();
    }

}
